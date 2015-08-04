package com.example.kyawzinlatt94.services;

import com.example.kyawzinlatt94.model.NutritionFact;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import retrofit.RestAdapter;

/**
 * Created by kyawzinlatt94 on 7/28/15.
 * This class is responsible for connect and query.
 */
public class RestClient {

    private final String BASE_URL = "http://test.holmusk.com";
    private List<NutritionFact> responseList;

    //Constructor
    public RestClient(){

    }

    /**
     * Request the nutrition facts with the foodname query
     * @param foodName Query
     * @return NutritionFact List for the food
     */
    public List<NutritionFact> fetchNutritionFact(final String foodName){
        final CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint(BASE_URL).build();
                    ApiService service = restAdapter.create(ApiService.class);
                    responseList = service.getContentByName(foodName);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        thread.start();
        try{
            latch.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

//        responseList = null;
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(BASE_URL).build();
//        ApiService service = restAdapter.create(ApiService.class);
//            service.getContentByName(foodName, new Callback<List<NutritionFact>>() {
//                @Override
//                public void success(List<NutritionFact> food, Response response) {
//                    responseList = food;
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    error.printStackTrace();
//                }
//            });
        return responseList;
    }
}
