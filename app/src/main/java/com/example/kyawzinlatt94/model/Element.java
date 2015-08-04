package com.example.kyawzinlatt94.model;

import com.google.gson.annotations.Expose;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */
public class Element{

    @Expose
    private String unit;
    @Expose
    private float value;

    /**
     *
     * @return
     * The unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     *
     * @param unit
     * The unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     *
     * @return
     * The value
     */
    public float getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(int value) {
        this.value = value;
    }

}
