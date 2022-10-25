package com.example.loginapi1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("Login")
    static Call<ModelClass> userlogin(@Body LoginRequest loginRequest) {
        return null;
    }
}