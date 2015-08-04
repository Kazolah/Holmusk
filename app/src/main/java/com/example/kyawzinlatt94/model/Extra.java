package com.example.kyawzinlatt94.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */
public class Extra {

    @SerializedName("vitamin_a")
    @Expose
    private Element vitaminA;
    @Expose
    private Element retinol;
    @Expose
    private Element iron;
    @Expose
    private Element nitrogen;
    @Expose
    private Element calcium;
    @SerializedName("vitamin_c")
    @Expose
    private Element vitaminC;
    @Expose
    private Element starch;
    @SerializedName("b-carotene")
    @Expose
    private Element bCarotene;

    /**
     *
     * @return
     * The vitaminA
     */
    public Element getVitaminA() {
        return vitaminA;
    }

    /**
     *
     * @param vitaminA
     * The vitamin_a
     */
    public void setVitaminA(Element vitaminA) {
        this.vitaminA = vitaminA;
    }

    /**
     *
     * @return
     * The retinol
     */
    public Element getRetinol() {
        return retinol;
    }

    /**
     *
     * @param retinol
     * The retinol
     */
    public void setRetinol(Element retinol) {
        this.retinol = retinol;
    }

    /**
     *
     * @return
     * The iron
     */
    public Element getIron() {
        return iron;
    }

    /**
     *
     * @param iron
     * The iron
     */
    public void setIron(Element iron) {
        this.iron = iron;
    }

    /**
     *
     * @return
     * The nitrogen
     */
    public Element getNitrogen() {
        return nitrogen;
    }

    /**
     *
     * @param nitrogen
     * The nitrogen
     */
    public void setNitrogen(Element nitrogen) {
        this.nitrogen = nitrogen;
    }

    /**
     *
     * @return
     * The calcium
     */
    public Element getCalcium() {
        return calcium;
    }

    /**
     *
     * @param calcium
     * The calcium
     */
    public void setCalcium(Element calcium) {
        this.calcium = calcium;
    }

    /**
     *
     * @return
     * The vitaminC
     */
    public Element getVitaminC() {
        return vitaminC;
    }

    /**
     *
     * @param vitaminC
     * The vitamin_c
     */
    public void setVitaminC(Element vitaminC) {
        this.vitaminC = vitaminC;
    }

    /**
     *
     * @return
     * The starch
     */
    public Element getStarch() {
        return starch;
    }

    /**
     *
     * @param starch
     * The starch
     */
    public void setStarch(Element starch) {
        this.starch = starch;
    }

    /**
     *
     * @return
     * The bCarotene
     */
    public Element getBCarotene() {
        return bCarotene;
    }

    /**
     *
     * @param bCarotene
     * The b-carotene
     */
    public void setBCarotene(Element bCarotene) {
        this.bCarotene = bCarotene;
    }

}
