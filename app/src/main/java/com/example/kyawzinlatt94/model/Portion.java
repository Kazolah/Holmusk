package com.example.kyawzinlatt94.model;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */

import com.google.gson.annotations.Expose;

public class Portion{

    @Expose
    private Nutrients nutrients;
    @Expose
    private String name;

    /**
     *
     * @return
     * The nutrients
     */
    public Nutrients getNutrients() {
        return nutrients;
    }

    /**
     *
     * @param nutrients
     * The nutrients
     */
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }
}