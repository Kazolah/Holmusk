package com.example.kyawzinlatt94.model;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Important {


    @SerializedName("dietary_fibre")
    @Expose
    private Element dietaryFibre;
    @Expose
    private Object trans;
    @Expose
    private Element saturated;
    @SerializedName("total_carbs")
    @Expose
    private Element totalCarbs;
    @Expose
    private Element sodium;
    @Expose
    private Element potassium;
    @Expose
    private Element polyunsaturated;
    @Expose
    private Element calories;
    @Expose
    private Element sugar;
    @SerializedName("total_fats")
    @Expose
    private Element totalFats;
    @Expose
    private Element monounsaturated;
    @Expose
    private Element cholesterol;
    @Expose
    private Element protein;

    /**
     *
     * @return
     * The dietaryFibre
     */
    public Element getDietaryFibre() {
        return dietaryFibre;
    }

    /**
     *
     * @param dietaryFibre
     * The dietary_fibre
     */
    public void setDietaryFibre(Element dietaryFibre) {
        this.dietaryFibre = dietaryFibre;
    }

    /**
     *
     * @return
     * The trans
     */
    public Object getTrans() {
        return trans;
    }

    /**
     *
     * @param trans
     * The trans
     */
    public void setTrans(Object trans) {
        this.trans = trans;
    }

    /**
     *
     * @return
     * The saturated
     */
    public Element getSaturated() {
        return saturated;
    }

    /**
     *
     * @param saturated
     * The saturated
     */
    public void setSaturated(Element saturated) {
        this.saturated = saturated;
    }

    /**
     *
     * @return
     * The totalCarbs
     */
    public Element getTotalCarbs() {
        return totalCarbs;
    }

    /**
     *
     * @param totalCarbs
     * The total_carbs
     */
    public void setTotalCarbs(Element totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    /**
     *
     * @return
     * The sodium
     */
    public Element getSodium() {
        return sodium;
    }

    /**
     *
     * @param sodium
     * The sodium
     */
    public void setSodium(Element sodium) {
        this.sodium = sodium;
    }

    /**
     *
     * @return
     * The potassium
     */
    public Element getPotassium() {
        return potassium;
    }

    /**
     *
     * @param potassium
     * The potassium
     */
    public void setPotassium(Element potassium) {
        this.potassium = potassium;
    }

    /**
     *
     * @return
     * The polyunsaturated
     */
    public Element getPolyunsaturated() {
        return polyunsaturated;
    }

    /**
     *
     * @param polyunsaturated
     * The polyunsaturated
     */
    public void setPolyunsaturated(Element polyunsaturated) {
        this.polyunsaturated = polyunsaturated;
    }

    /**
     *
     * @return
     * The calories
     */
    public Element getCalories() {
        return calories;
    }

    /**
     *
     * @param calories
     * The calories
     */
    public void setCalories(Element calories) {
        this.calories = calories;
    }

    /**
     *
     * @return
     * The sugar
     */
    public Element getSugar() {
        return sugar;
    }

    /**
     *
     * @param sugar
     * The sugar
     */
    public void setSugar(Element sugar) {
        this.sugar = sugar;
    }

    /**
     *
     * @return
     * The totalFats
     */
    public Element getTotalFats() {
        return totalFats;
    }

    /**
     *
     * @param totalFats
     * The total_fats
     */
    public void setTotalFats(Element totalFats) {
        this.totalFats = totalFats;
    }

    /**
     *
     * @return
     * The monounsaturated
     */
    public Element getMonounsaturated() {
        return monounsaturated;
    }

    /**
     *
     * @param monounsaturated
     * The monounsaturated
     */
    public void setMonounsaturated(Element monounsaturated) {
        this.monounsaturated = monounsaturated;
    }

    /**
     *
     * @return
     * The cholesterol
     */
    public Element getCholesterol() {
        return cholesterol;
    }

    /**
     *
     * @param cholesterol
     * The cholesterol
     */
    public void setCholesterol(Element cholesterol) {
        this.cholesterol = cholesterol;
    }

    /**
     *
     * @return
     * The protein
     */
    public Element getProtein() {
        return protein;
    }

    /**
     *
     * @param protein
     * The protein
     */
    public void setProtein(Element protein) {
        this.protein = protein;
    }

}