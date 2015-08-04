package com.example.kyawzinlatt94.realmObjects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 */
public class DailyDiet extends RealmObject{

    @PrimaryKey
    private int id;
    private String totalCalorie;
    private String breakfastCalorie;
    private String lunchCalorie;
    private String dinnerCalorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDinnerCalorie() {
        return dinnerCalorie;
    }

    public void setDinnerCalorie(String dinnerCalorie) {
        this.dinnerCalorie = dinnerCalorie;
    }

    public String getLunchCalorie() {
        return lunchCalorie;
    }

    public void setLunchCalorie(String lunchCalorie) {
        this.lunchCalorie = lunchCalorie;
    }

    public String getBreakfastCalorie() {
        return breakfastCalorie;
    }

    public void setBreakfastCalorie(String breakfastCalorie) {
        this.breakfastCalorie = breakfastCalorie;
    }

    public String getTotalCalorie() {
        return totalCalorie;
    }

    public void setTotalCalorie(String totalCalorie) {
        this.totalCalorie = totalCalorie;
    }
}
