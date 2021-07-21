package com.example.dogbreedapp

import retrofit2.Call
import retrofit2.http.GET

interface DogApi {
    @get:GET("api/breeds/list/all")
    val root: Call<Root?>?
}