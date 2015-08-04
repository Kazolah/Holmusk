package com.example.kyawzinlatt94.model;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NutritionFact{

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String name;
    @Expose
    private List<Portion> portions = new ArrayList<Portion>();

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
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

    /**
     *
     * @return
     * The portions
     */
    public List<Portion> getPortions() {
        return portions;
    }

    /**
     *
     * @param portions
     * The portions
     */
    public void setPortions(List<Portion> portions) {
        this.portions = portions;
    }

}