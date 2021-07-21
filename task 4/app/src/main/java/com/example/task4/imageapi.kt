package com.example.dogbreedapp

import android.provider.MediaStore.Images
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageApi {
    @GET("api/breed/{breed}/images/random")
    fun getImage(@Path("breed") breed: String?): Call<Images?>?
}