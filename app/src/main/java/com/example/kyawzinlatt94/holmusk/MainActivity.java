package com.example.kyawzinlatt94.holmusk;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kyawzinlatt94.model.NutritionFact;
import com.example.kyawzinlatt94.realmObjects.FoodNutrients;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements FoodNameFragment.onFoodNameSelectedListener,
        FoodAmountFragment.onFoodPortionSelectedListener, MainFragment.onRecentSearchSelectedListener{

    private DailyDietFragment dailyDietFragment;
    private FoodNameFragment foodNameFragment;
    private FoodAmountFragment foodAmountFragment;
    private FoodNutritionFactsFragment foodNutritionFactsFragment;
    private JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.main_container, mainFragment)
                .addToBackStack("main fragment").commit();

        try {
            obj = new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        foodNameFragment = new FoodNameFragment();
        foodAmountFragment = new FoodAmountFragment();
        foodNutritionFactsFragment = new FoodNutritionFactsFragment();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * FoodNameFragment.onFoodNameSelectedListener interface method
     * Trigger when the item on FoodNameFragment is selected on the list
     * @param nutritionFact Selected food from list
     */
    public void onFoodNameSelected(NutritionFact nutritionFact){
        loadFoodAmountFragment(nutritionFact);
    }

    /**
     * FoodNameFragment.onFoodNameSelectedListener interface method
     * Trigger when the item on FoodNameFragment is selected on the list
     * @param foodNutrition
     */
    public void onFoodPortionSelected(FoodNutrients foodNutrition){
        loadFoodNutritionFactsFragment(foodNutrition);
    }

    /**
     * MainFragment.onRecentSearchSelectedListener interface method
     * Trigger when the item on RecentSearch is selected on the list
     * @param foodNutrition
     */
    public void onRecentSearchSelected(FoodNutrients foodNutrition){
        loadFoodNutritionFactsFragment(foodNutrition);
    }

    /**
     * Replace MainFragment with FoodNameFragment, where list of food name is displayed.
     * @param nutritionFactList Response list from WebLink
     */
    public void loadFoodNameFragment(List<NutritionFact> nutritionFactList){
        FoodNameFragment.setNutritionFactList(nutritionFactList);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.main_container, foodNameFragment)
                .addToBackStack("food name").commit();
    }

    /**
     * Replace the fragment with FoodAmountFragment, where list of portion for food is displayed.
     * @param nutritionFact Selected food from list
     */
    public void loadFoodAmountFragment(NutritionFact nutritionFact){
        FoodAmountFragment.setNutritionFact(nutritionFact);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.main_container, foodAmountFragment)
                .addToBackStack("food amount").commit();
    }

    /**
     * Replace the fragment with NutritionFactsFragment, where list of portion for food is displayed.
     * @param foodNutrition Selected food from list
     */
    public void loadFoodNutritionFactsFragment(FoodNutrients foodNutrition){
        FoodNutritionFactsFragment.setFoodNutrients(foodNutrition);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.main_container, foodNutritionFactsFragment)
                .addToBackStack("food nutrition facts").commit();
    }

    /**
     * Replace the fragment with DailyDietFragment, where list of portion for food is displayed.
     */
    public void loadDailyDietFragment(){
        dailyDietFragment = new DailyDietFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.main_container, dailyDietFragment)
                .addToBackStack("daily diet").commit();
    }

    /**
     * Parse the JSON Objects in String List for AutocompleteTextView
     * @return
     */
    public List<String> getFoodList(){
        if(obj == null) return null;
        List<String> responseList = new ArrayList<String>();
        try{
            JSONArray jsonArray = obj.getJSONArray("collection1");
            for(int i=0;i<jsonArray.length();i++){
                    JSONObject json = (JSONObject) jsonArray.get(i);
                    String name = json.getString("foodlist");
                    String lines[] = name.split("\\r?\\n");
                    for(String record:lines){
                        responseList.add(record);
                    }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseList;
    }

    /**
     * Load food list JSON from asset
     * @return
     */
    public String loadJSONFromAsset(){
        String json = null;
        try{
            InputStream is = getAssets().open("kimonoData.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
