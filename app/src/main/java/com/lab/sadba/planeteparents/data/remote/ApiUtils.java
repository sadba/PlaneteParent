package com.lab.sadba.planeteparents.data.remote;

/**
 * Created by sadba on 28-Mar-18.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://api.education.sn/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
