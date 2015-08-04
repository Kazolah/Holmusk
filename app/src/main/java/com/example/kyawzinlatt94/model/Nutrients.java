package com.example.kyawzinlatt94.model;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Nutrients{

    @Expose
    private List<Object> unhandled = new ArrayList<Object>();
    @Expose
    private Important important;
    @Expose
    private Extra extra;

    /**
     *
     * @return
     * The unhandled
     */
    public List<Object> getUnhandled() {
        return unhandled;
    }

    /**
     *
     * @param unhandled
     * The unhandled
     */
    public void setUnhandled(List<Object> unhandled) {
        this.unhandled = unhandled;
    }

    /**
     *
     * @return
     * The important
     */
    public Important getImportant() {
        return important;
    }

    /**
     *
     * @param important
     * The important
     */
    public void setImportant(Important important) {
        this.important = important;
    }

    /**
     *
     * @return
     * The extra
     */
    public Extra getExtra() {
        return extra;
    }

    /**
     *
     * @param extra
     * The extra
     */
    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    /**
     *
     * @return
     * The dietaryFibre
     */
    public Element getDietaryFibre() {
        return getImportant().getDietaryFibre();
    }
    /**
     *
     * @return
     * The saturated
     */
    public Element getSaturated() {
        return getImportant().getSaturated();
    }

    /**
     *
     * @return
     * The totalCarbs
     */
    public Element getTotalCarbs() {
        return getImportant().getTotalCarbs();
    }

    /**
     *
     * @return
     * The sodium
     */
    public Element getSodium() {
        return getImportant().getSodium();
    }

    /**
     *
     * @return
     * The potassium
     */
    public Element getPotassium() {
        return getImportant().getPotassium();
    }

    /**
     *
     * @return
     * The polyunsaturated
     */
    public Element getPolyunsaturated() {
        return getImportant().getPolyunsaturated();
    }

    /**
     *
     * @return
     * The calories
     */
    public Element getCalories() {
        return getImportant().getCalories();
    }

    /**
     *
     * @return
     * The sugar
     */
    public Element getSugar() {
        return getImportant().getSugar();
    }

    /**
     *
     * @return
     * The totalFats
     */
    public Element getTotalFats() {
        return getImportant().getTotalFats();
    }

    /**
     *
     * @return
     * The monounsaturated
     */
    public Element getMonounsaturated() {
        return getImportant().getMonounsaturated();
    }

    /**
     *
     * @return
     * The cholesterol
     */
    public Element getCholesterol() {
        return getImportant().getCholesterol();
    }

    /**
     *
     * @return
     * The protein
     */
    public Element getProtein() {
        return getImportant().getProtein();
    }

    /**
     *
     * @return
     * The vitaminA
     */
    public Element getVitaminA() {
        return getExtra().getVitaminA();
    }

    /**
     *
     * @return
     * The retinol
     */
    public Element getRetinol() {
        return getExtra().getRetinol();
    }

    /**
     *
     * @return
     * The iron
     */
    public Element getIron() {
        return getExtra().getIron();
    }

    /**
     *
     * @return
     * The nitrogen
     */
    public Element getNitrogen() {
        return getExtra().getNitrogen();
    }

    /**
     *
     * @return
     * The calcium
     */
    public Element getCalcium() {
        return getExtra().getCalcium();
    }

    /**
     *
     * @return
     * The vitaminC
     */
    public Element getVitaminC() {
        return getExtra().getVitaminC();
    }

    /**
     *
     * @return
     * The starch
     */
    public Element getStarch() {
        return getExtra().getStarch();
    }

    /**
     *
     * @return
     * The bCarotene
     */
    public Element getBCarotene() {
        return getExtra().getBCarotene();
    }

}