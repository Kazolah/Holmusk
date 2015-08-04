package com.example.kyawzinlatt94.holmusk;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.kyawzinlatt94.model.NutritionFact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 *
 * This Fragment is used to present the list of food names returned form the server
 */
public class FoodNameFragment extends Fragment{

    //UI Reference
    private ListView lvFoodName;
    private SimpleAdapter adapterNutritionFact;
    private onFoodNameSelectedListener listener;
    private MainActivity mainActivity;
    private static List<NutritionFact> lsNutritionFact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food_name, container, false);
        lvFoodName = (ListView) rootView.findViewById(R.id.lvFoodName);

        ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Parse the Nutrition List into String list to display
        ArrayList<HashMap<String, String>> list = parseNutritionFactToStringList(lsNutritionFact);
        adapterNutritionFact = new SimpleAdapter(getActivity(), list,
                R.layout.custom_row_view_listitems, new String[]{"Food Name"}, new int[]{R.id.listItemName});

        lvFoodName.setAdapter(adapterNutritionFact);
        lvFoodName.setOnItemClickListener(listItemListener);

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch(menuItem.getItemId()){
            case android.R.id.home:
                mainActivity.onBackPressed();
                break;
        }
        return true;
    }

    /**
     * NutritionFactList Setter to load on the list
     * @param nutritionFactList
     */
    public static void setNutritionFactList(List<NutritionFact> nutritionFactList){
        lsNutritionFact = nutritionFactList;
    }

    /**
     * To parse the NutritionList into String List
     * @param nutritionFactList List to be parsed
     * @return Parsed List of String Required by Simple Adapter
     */
    private ArrayList<HashMap<String, String>> parseNutritionFactToStringList(List<NutritionFact> nutritionFactList){
        ArrayList<HashMap<String, String>> lsNutritionFact = new ArrayList<HashMap<String, String>> ();
        try {
            for (NutritionFact nutritionItem : nutritionFactList) {
                HashMap<String, String> temp = new HashMap<String, String>();
                temp.put("Food Name", nutritionItem.getName());
                lsNutritionFact.add(temp);
            }
        }catch(NullPointerException e){
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put("Food Name", "No Results Found!");
            lsNutritionFact.add(temp);
        }
        return lsNutritionFact;
    }

    /**
     *Listener for Food List items
     */
    private AdapterView.OnItemClickListener listItemListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View item,
                                int position, long rowId) {
            if(lsNutritionFact.size()<1)
                return;
            NutritionFact selectedItem = (NutritionFact) lsNutritionFact.get(position);
            listener.onFoodNameSelected(selectedItem);
        }
    };

    /**
     * Callback interface for MainActivity
     */
    public interface onFoodNameSelectedListener{
        public void onFoodNameSelected(NutritionFact nutritionFact);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        if(activity instanceof onFoodNameSelectedListener){
            listener = (onFoodNameSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement FoodNameFragment.onFoodNameSelectedListener");
        }
    }
}
