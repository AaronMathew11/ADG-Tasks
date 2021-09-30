package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    val name =fun getname()
    @GET("/api/breeds/image/random")
    suspend fun getDogImage(): Response<DogImageModel>
}