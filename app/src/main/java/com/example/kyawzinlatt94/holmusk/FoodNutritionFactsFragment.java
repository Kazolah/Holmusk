package com.example.kyawzinlatt94.holmusk;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kyawzinlatt94.realmObjects.FoodNutrients;

import io.realm.Realm;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 */
public class FoodNutritionFactsFragment extends Fragment{

    private static FoodNutrients foodNutrients;

    //UI References
    private TextView tvHeader;

    private TextView tvVitaminA;
    private TextView tvVitaminC;
    private TextView tvCalcium;
    private TextView tvNitrogen;
    private TextView tvIron;
    private TextView tvStarch;

    private TextView tvDietaryFibre;
    private TextView tvTotalCarbs;
    private TextView tvSodium;
    private TextView tvPolyunsaturated;
    private TextView tvCalories;
    private TextView tvSugar;
    private TextView tvTotalFats;
    private TextView tvMonounsaturated;
    private TextView tvCholesterol;
    private TextView tvProtein;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nutrition_fact, container, false);

        ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvHeader = (TextView) rootView.findViewById(R.id.tvHeader);
        tvHeader.setText(getHeader());

        //For Nutrients Important Section
        tvDietaryFibre = (TextView) rootView.findViewById(R.id.tvFibre);
        tvTotalCarbs = (TextView) rootView.findViewById(R.id.tvCarbs);
        tvSodium = (TextView) rootView.findViewById(R.id.tvSodium);
        tvPolyunsaturated = (TextView) rootView.findViewById(R.id.tvPolysaturated);
        tvMonounsaturated = (TextView) rootView.findViewById(R.id.tvMonosaturated);
        tvCalories = (TextView) rootView.findViewById(R.id.tvCalorie);
        tvTotalFats = (TextView) rootView.findViewById(R.id.tvFat);
        tvSugar = (TextView) rootView.findViewById(R.id.tvSugar);
        tvCholesterol = (TextView) rootView.findViewById(R.id.tvCholestrol);
        tvProtein = (TextView) rootView.findViewById(R.id.tvProtein);

        tvDietaryFibre.setText(foodNutrients.getDietaryFibre());
        tvTotalCarbs.setText(foodNutrients.getTotalCarbs());
        tvSodium.setText(foodNutrients.getSodium());
        tvPolyunsaturated.setText(foodNutrients.getPolyunsaturated());
        tvMonounsaturated.setText(foodNutrients.getMonounsaturated());
        tvCalories.setText(foodNutrients.getCalories());
        tvTotalFats.setText(foodNutrients.getTotalFats());
        tvSugar.setText(foodNutrients.getSugar());
        tvCholesterol.setText(foodNutrients.getCholesterol());
        tvProtein.setText(foodNutrients.getProtein());

        //For Vitamin Section
        tvVitaminA = (TextView) rootView.findViewById(R.id.tvVitaminA);
        tvVitaminC = (TextView) rootView.findViewById(R.id.tvVitaminC);
        tvCalcium = (TextView) rootView.findViewById(R.id.tvCalcium);
        tvNitrogen = (TextView) rootView.findViewById(R.id.tvNitrogen);
        tvIron = (TextView) rootView.findViewById(R.id.tvIron);
        tvStarch = (TextView) rootView.findViewById(R.id.tvStarch);

        tvVitaminA.setText(foodNutrients.getVitaminA());
        tvVitaminC.setText(foodNutrients.getVitaminC());
        tvCalcium.setText(foodNutrients.getCalcium());
        tvNitrogen.setText(foodNutrients.getNitrogen());
        tvIron.setText(foodNutrients.getIron());
        tvStarch.setText(foodNutrients.getStarch());

        //Save the searched record
        saveRecord();
        return rootView;
    }

    public String getHeader(){
        String header = foodNutrients.getName() + "\nServing: " + foodNutrients.getPortion();
        return header;
    }
    public static void setFoodNutrients(FoodNutrients record){
        foodNutrients = record;
    }

    public void saveRecord(){
        Realm realm = Realm.getInstance(getActivity());
        realm.beginTransaction();
        FoodNutrients realmRecord = realm.copyToRealm(foodNutrients);
        realm.commitTransaction();
    }
}

