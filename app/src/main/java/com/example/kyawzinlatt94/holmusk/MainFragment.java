package com.example.kyawzinlatt94.holmusk;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.kyawzinlatt94.model.NutritionFact;
import com.example.kyawzinlatt94.realmObjects.FoodNutrients;
import com.example.kyawzinlatt94.services.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 */
public class MainFragment extends Fragment {

    private static final String NAME_TAG = "Food Name";
    private static final String PORTION_TAG = "Portion";

    private Context context;
    private MainActivity mainActivity;

    private ArrayAdapter<String> adapterFoodList;
    private SimpleAdapter adapterRecentSearch;

    private RealmResults<FoodNutrients> results;
    private onRecentSearchSelectedListener listener;

    //UI References
    private TextView tvDesc1; //TextView to be animated
    private ImageView ibSearch;
    private ImageView ibAddDiet;
    private ListView lvRecentSearches;
    private AutoCompleteTextView actvSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();

        //Get Food List From JSON to populate in the autocomplete view
        List<String> foodList = mainActivity.getFoodList();
        adapterFoodList = new ArrayAdapter<String>(getActivity(),
                R.layout.custom_dropdown_item, foodList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tvDesc1 = (TextView) rootView.findViewById(R.id.tvDesc1);
        ibSearch = (ImageView) rootView.findViewById(R.id.ibSearch);
        ibAddDiet = (ImageView) rootView.findViewById(R.id.ibAddDiet);
        actvSearch = (AutoCompleteTextView) rootView.findViewById(R.id.actvSearch);
        lvRecentSearches = (ListView) rootView.findViewById(R.id.lvRecentSearch);

        //Must Populate adapter first
        populateAdapterRecentSearch();
        lvRecentSearches.setAdapter(adapterRecentSearch);
        lvRecentSearches.setOnItemClickListener(listItemListener);

        actvSearch.setAdapter(adapterFoodList);
        ibSearch.setOnClickListener(imgBtnSearchListener);
        ibAddDiet.setOnClickListener(imgBtnAddDietListener);

        //Play Animation on text
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tvDesc1);
        return rootView;
    }

    /**
     * Load Recent Searches saved in the database
     * @return Result List
     */
    private RealmResults<FoodNutrients> loadRecentSearches(){
        Realm realm = Realm.getInstance(getActivity());

        //Build the query looking at all food nutrients
        RealmQuery<FoodNutrients> query = realm.where(FoodNutrients.class);

        //Execute the query
        RealmResults<FoodNutrients> result = query.findAll();
        return result;
    }

    /**
     * Parse the Results List into String List to populate in ListView
     * @param foodNutrientList
     * @return
     */
    private ArrayList<HashMap<String, String>> parseFoodNutrientsToStringList
            (RealmResults<FoodNutrients> foodNutrientList){

        ArrayList<HashMap<String, String>> lsNutritionFact
                = new ArrayList<HashMap<String, String>> ();
        try {
            for (FoodNutrients nutritionItem : foodNutrientList) {
                HashMap<String, String> temp = new HashMap<String, String>();
                temp.put(NAME_TAG, nutritionItem.getName());
                temp.put(PORTION_TAG, nutritionItem.getPortion());
                lsNutritionFact.add(temp);
            }
        }catch(NullPointerException e){
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put(NAME_TAG, "No Recent Search!");
            temp.put(PORTION_TAG, "");
            lsNutritionFact.add(temp);
        }
        if(lsNutritionFact.size()<1){
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put(NAME_TAG, "No Recent Search!");
            temp.put(PORTION_TAG, "");
            lsNutritionFact.add(temp);
        }
        return lsNutritionFact;
    }

    /**
     * Populate Adapter for ResearchList
     */
    private void populateAdapterRecentSearch(){
        results = loadRecentSearches();
        ArrayList<HashMap<String, String>> list = parseFoodNutrientsToStringList(results);
        adapterRecentSearch = new SimpleAdapter(getActivity(), list,
                R.layout.custom_row_view_recent_items,
                new String[]{NAME_TAG, PORTION_TAG},
                new int[]{R.id.tvRecentItemName, R.id.tvRecentItemServing});
    }


    /**
     *Listener for Food List items
     */
    private AdapterView.OnItemClickListener listItemListener
            = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View item,
                                int position, long rowId) {
            if(results.size()<1)
                return;
            FoodNutrients selectedItem = (FoodNutrients) results.get(position);
            listener.onRecentSearchSelected(selectedItem);
        }
    };

    /**
     * Listener Variable for search button
     */
    private View.OnClickListener imgBtnSearchListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String foodName = actvSearch.getText().toString();

            LoadService loadService = new LoadService();
            loadService.execute(new String[]{foodName});

        }
    };

    private View.OnClickListener imgBtnAddDietListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String foodName = actvSearch.getText().toString();
            mainActivity.loadDailyDietFragment();
        }
    };

    /**
     * Callback interface for MainActivity
     */
    public interface onRecentSearchSelectedListener{
        public void onRecentSearchSelected(FoodNutrients foodNutrients);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        if(activity instanceof onRecentSearchSelectedListener){
            listener = (onRecentSearchSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement MainFragment.onRecentSearchSelected");
        }
    }

    /**
     * Load Service class is responsible to show dialog box while loading data
     */
    private class LoadService extends AsyncTask<String, Void, Boolean> {
        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading. Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... arg0) {
            RestClient restClient = new RestClient();
            //Fetch data from Weblink
            List<NutritionFact> nutritionFactList = restClient.fetchNutritionFact(arg0[0]);
            mainActivity.loadFoodNameFragment(nutritionFactList);
            dialog.dismiss();
            return true;
        }
    }

}
