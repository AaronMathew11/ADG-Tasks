package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/breeds/list/all")
    fun getData(): Call<List<Names>>
}