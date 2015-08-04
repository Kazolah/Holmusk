package com.example.kyawzinlatt94.holmusk;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.kyawzinlatt94.realmObjects.DailyDiet;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 * This class is responsible for Daily Nutrient Screen
 */
public class DailyDietFragment extends Fragment{

    private DailyDiet dailyDiet;

    //UI References
    private RoundCornerProgressBar progressBar;
    private TextView tvTotalCalConsumed;
    private TextView tvBreakfastCal;
    private TextView tvLunchCal;
    private TextView tvDinnerCal;
    private Button btnEdit;
    private BarChart barchart;
    private EditText edtBreakfast;
    private EditText edtLunch;
    private EditText edtDinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily_diet, container, false);

        ActionBarActivity activity = (ActionBarActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = (RoundCornerProgressBar) rootView.findViewById(R.id.progressBar);
        tvTotalCalConsumed = (TextView) rootView.findViewById(R.id.tvTotalCalConsumed);
        tvBreakfastCal = (TextView) rootView.findViewById(R.id.tvBreakfastCal);
        tvLunchCal = (TextView) rootView.findViewById(R.id.tvLunchCal);
        tvDinnerCal = (TextView) rootView.findViewById(R.id.tvDinnerCal);
        btnEdit = (Button) rootView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(btnEditListener);
        barchart = (BarChart) rootView.findViewById(R.id.barchart);

        if(loadData().size()>0){
            dailyDiet = loadData().get(0);
            tvBreakfastCal.setText(dailyDiet.getBreakfastCalorie());
            tvLunchCal.setText(dailyDiet.getLunchCalorie());
            tvDinnerCal.setText(dailyDiet.getDinnerCalorie());
            tvTotalCalConsumed.setText(dailyDiet.getTotalCalorie());
            int consumedCal = Integer.parseInt(dailyDiet.getTotalCalorie());
            progressBar.setProgress(0);
            progressBar.setProgress(consumedCal);
        }
        progressBar.refreshDrawableState();
        populateBarChart();
        return rootView;
    }

    private View.OnClickListener btnEditListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            final Dialog dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.fragment_dialog_add_meal);
            dialog.setTitle("Add Meal");
            edtBreakfast = (EditText) dialog.findViewById(R.id.edtBreakfastCal);
            edtLunch = (EditText) dialog.findViewById(R.id.edtLunchCal);
            edtDinner = (EditText) dialog.findViewById(R.id.edtDinnerCal);
            Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            Button btnSave = (Button) dialog.findViewById(R.id.btnSave);
            btnSave.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    saveData();
                    updateScreen();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    };

    public void updateScreen(){
        tvBreakfastCal.setText(edtBreakfast.getText().toString());
        tvLunchCal.setText(edtLunch.getText().toString());
        tvDinnerCal.setText(edtDinner.getText().toString());
        int totalCal = Integer.parseInt(tvBreakfastCal.getText().toString()) +
                Integer.parseInt(tvLunchCal.getText().toString()) +
                Integer.parseInt(tvDinnerCal.getText().toString());
        tvTotalCalConsumed.setText(String.valueOf(totalCal));

        //Update Progress Bar
        progressBar.setProgress(totalCal);

        //Update Bar Chart
        populateBarChart();
        barchart.animateXY(1000,1000);
    }

    public void saveData(){
        Realm realm = Realm.getInstance(getActivity());
        realm.beginTransaction();
        DailyDiet dailyDiet = new DailyDiet();
        dailyDiet.setId(1);
        dailyDiet.setTotalCalorie(tvTotalCalConsumed.getText().toString());
        dailyDiet.setBreakfastCalorie(tvBreakfastCal.getText().toString());
        dailyDiet.setLunchCalorie(tvLunchCal.getText().toString());
        dailyDiet.setDinnerCalorie(tvDinnerCal.getText().toString());
        realm.commitTransaction();

    }

    public RealmResults<DailyDiet> loadData(){
        Realm realm = Realm.getInstance(getActivity());

        //Build the query looking at all food nutrients
        RealmQuery<DailyDiet> query = realm.where(DailyDiet.class);

        //Execute the query
        RealmResults<DailyDiet> result = query.findAll();
        return result;
    }

    public void populateBarChart(){
        BarEntry e1, e2, e3;
        BarDataSet breakfast, lunch, dinner;
        float breakfastCalInFloat, lunchCalInFloat, dinnerCalInFloat;
        ArrayList<BarEntry> breakfastCal = new ArrayList<BarEntry>();
        ArrayList<BarEntry> lunchCal = new ArrayList<BarEntry>();
        ArrayList<BarEntry> dinnerCal = new ArrayList<BarEntry>();

        try {
            breakfastCalInFloat = Float.parseFloat(tvBreakfastCal.getText().toString());
            lunchCalInFloat = Float.parseFloat(tvLunchCal.getText().toString());
            dinnerCalInFloat = Float.parseFloat(tvDinnerCal.getText().toString());
        }catch(NullPointerException e){
            breakfastCalInFloat = 0;
            lunchCalInFloat = 0;
            dinnerCalInFloat = 0;
        }
        e1 = new BarEntry(breakfastCalInFloat,0);
        breakfastCal.add(e1);

        e2 = new BarEntry(lunchCalInFloat,0);
        lunchCal.add(e2);

        e3 = new BarEntry(dinnerCalInFloat,0);
        dinnerCal.add(e3);

        breakfast = new BarDataSet(breakfastCal, "Breakfast");
        breakfast.setColor(getResources().getColor(R.color.orange));

        lunch = new BarDataSet(lunchCal, "Lunch");
        lunch.setColor(getResources().getColor(R.color.holo_blue_light));

        dinner = new BarDataSet(dinnerCal, "Dinner");
        dinner.setColor(getResources().getColor(R.color.holo_green_light));

        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        dataSets.add(breakfast);
        dataSets.add(lunch);
        dataSets.add(dinner);

        ArrayList<String> xVals = new ArrayList<>();
        xVals.add("Meals");

        BarData data = new BarData(xVals, dataSets);
        barchart.setData(data);
    }
}

