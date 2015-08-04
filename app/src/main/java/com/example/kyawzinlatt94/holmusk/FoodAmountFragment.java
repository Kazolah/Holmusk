package com.example.kyawzinlatt94.holmusk;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.kyawzinlatt94.model.NutritionFact;
import com.example.kyawzinlatt94.model.Portion;
import com.example.kyawzinlatt94.realmObjects.FoodNutrients;
import com.example.kyawzinlatt94.util.ObjectConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 *
 * This Fragment is used to present the list of food portion for selected food item
 */
public class FoodAmountFragment extends Fragment{

    private final String NAME_TAG = "Food Amount";

    private static NutritionFact nutritionFact;

    //UI References
    private ListView lvFoodAmount;
    private SimpleAdapter adapterNutritionFact;
    private onFoodPortionSelectedListener listener;
    private MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food_amount, container, false);

        ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvFoodAmount= (ListView) rootView.findViewById(R.id.lvFoodAmount);

        ArrayList<HashMap<String, String>> list = parsePortionsToString(nutritionFact);
        adapterNutritionFact = new SimpleAdapter(getActivity(), list, R.layout.custom_row_view_listitems,
                new String[]{NAME_TAG}, new int[]{R.id.listItemName});

        lvFoodAmount.setAdapter(adapterNutritionFact);
        lvFoodAmount.setOnItemClickListener(listItemListener);

        return rootView;
    }

    public static void setNutritionFact(NutritionFact selectedItem){
         nutritionFact = selectedItem;
    }

    /**
     * To parse the PortionList into String List
     * @param nutritionFact List to be parsed
     * @return Parsed List of String Required by Simple Adapter
     */
    public ArrayList<HashMap<String, String>> parsePortionsToString(NutritionFact nutritionFact){
        List<Portion> portionsList = nutritionFact.getPortions();
        ArrayList<HashMap<String,String>> parsedList = new ArrayList<HashMap<String,String>>();
        for(Portion portion: portionsList){
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put(NAME_TAG, portion.getName());
            parsedList.add(temp);
        }
        return parsedList;
    }

    /**
     * Listener for Food Portion items
     */
    private AdapterView.OnItemClickListener listItemListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View item,
                                int position, long rowId) {
            FoodNutrients foodNutrition = ObjectConverter.convertToFoodNutrition(nutritionFact, position);
            listener.onFoodPortionSelected(foodNutrition);
        }
    };

    /**
     * Callback interface for MainActivity
     */
    public interface onFoodPortionSelectedListener{
        public void onFoodPortionSelected(FoodNutrients nutritionFact);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
        if(activity instanceof onFoodPortionSelectedListener){
            listener = (onFoodPortionSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement FoodNameFragment.onFoodNameSelectedListener");
        }
    }
}
