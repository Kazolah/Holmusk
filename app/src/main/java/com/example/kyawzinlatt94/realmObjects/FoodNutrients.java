package com.example.kyawzinlatt94.realmObjects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kyawzinlatt94 on 8/1/15.
 */
public class FoodNutrients extends RealmObject{

    @PrimaryKey
    private String id;
    private String name;
    private String portion;

    //Important Facts
    private String dietaryFibre;
    private String trans;
    private String saturated;
    private String totalCarbs;
    private String sodium;
    private String potassium;
    private String polyunsaturated;
    private String calories;
    private String sugar;
    private String totalFats;
    private String monounsaturated;
    private String cholesterol;
    private String protein;

    //Extra Facts
    private String vitaminA;
    private String retinol;
    private String iron;
    private String nitrogen;
    private String calcium;
    private String vitaminC;
    private String starch;
    private String bCarotene;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDietaryFibre() {
        return dietaryFibre;
    }

    public void setDietaryFibre(String dietaryFibre) {
        this.dietaryFibre = dietaryFibre;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getSaturated() {
        return saturated;
    }

    public void setSaturated(String saturated) {
        this.saturated = saturated;
    }

    public String getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(String totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getPolyunsaturated() {
        return polyunsaturated;
    }

    public void setPolyunsaturated(String polyunsaturated) {
        this.polyunsaturated = polyunsaturated;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(String totalFats) {
        this.totalFats = totalFats;
    }

    public String getMonounsaturated() {
        return monounsaturated;
    }

    public void setMonounsaturated(String monounsaturated) {
        this.monounsaturated = monounsaturated;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getRetinol() {
        return retinol;
    }

    public void setRetinol(String retinol) {
        this.retinol = retinol;
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron;
    }

    public String getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(String nitrogen) {
        this.nitrogen = nitrogen;
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium;
    }

    public String getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(String vitaminC) {
        this.vitaminC = vitaminC;
    }

    public String getStarch() {
        return starch;
    }

    public void setStarch(String starch) {
        this.starch = starch;
    }

    public String getbCarotene() {
        return bCarotene;
    }

    public void setbCarotene(String bCarotene) {
        this.bCarotene = bCarotene;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }
}
