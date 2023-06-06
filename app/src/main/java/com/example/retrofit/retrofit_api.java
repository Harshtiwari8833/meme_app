package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface retrofit_api {
    @GET("gimme")
    Call<datamodel> getapi();

}
