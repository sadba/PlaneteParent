package com.lab.sadba.planeteparents.data.remote;


import com.lab.sadba.planeteparents.data.model.Enfant;
import com.lab.sadba.planeteparents.data.model.EnfantJson;
import com.lab.sadba.planeteparents.data.model.VerifParent;
import com.lab.sadba.planeteparents.data.model.postuser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sadba on 28-Mar-18.
 */

public interface APIService {

    @Headers("Content-type: application/json")
    @POST("api-ien/verif_parent")
    Call<VerifParent> saveUser(@Body postuser user);


    @Headers("Content-type: application/json")
    @GET("api-ien/enfants")
    Call<EnfantJson> getEnfants(@Query("ien_parent") String ien);
}
