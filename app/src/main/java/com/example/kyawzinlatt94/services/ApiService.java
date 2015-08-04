package com.example.kyawzinlatt94.services;

import com.example.kyawzinlatt94.model.NutritionFact;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 * An interface to make REST calls
 */
public interface ApiService {
    //synchronous
    @GET("/food/search")
    List<NutritionFact> getContentByName(@Query("q") String name);

    //asynchronous
    @GET("/food/search")
    void getContentByName(@Query("q") String name, Callback<List<NutritionFact>> callback);
}
