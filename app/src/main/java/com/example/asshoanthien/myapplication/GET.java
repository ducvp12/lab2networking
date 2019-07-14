package com.example.asshoanthien.myapplication;

import retrofit2.Call;
import retrofit2.http.Query;

public interface GET {
    @retrofit2.http.GET("wp-json/wp/v2/posts")
    Call<String> getCategories(@Query("page") String page, @Query("per_page") String per_page);
}
