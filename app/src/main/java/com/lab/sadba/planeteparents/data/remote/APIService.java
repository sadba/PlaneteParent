package com.lab.sadba.planeteparents.data.remote;


import com.lab.sadba.planeteparents.data.model.Resultat;
import com.lab.sadba.planeteparents.data.model.VerifParent;
import com.lab.sadba.planeteparents.data.model.postuser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by sadba on 28-Mar-18.
 */

public interface APIService {

    @Headers("Content-type: application/json")
    @POST("api/verif_parent")
    Call<VerifParent> saveUser(@Body postuser user);
}
