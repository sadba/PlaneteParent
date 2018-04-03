package com.lab.sadba.planeteparents.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sadba on 28-Mar-18.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://api.education.sn/";
    public static Retrofit  retrofit = null;

    public static Retrofit getAPIService() {

        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
