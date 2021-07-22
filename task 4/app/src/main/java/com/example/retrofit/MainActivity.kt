package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.api.load
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val base_url="https://dog.ceo/"
class MainActivity : AppCompatActivity(),CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMydata()























        btn_get_image.setOnClickListener {
            launch(Dispatchers.Main) {

                try {
                    val response = ApiAdapter.apiClient.getDogImage()

                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!
                        data.message?.let { imageUrl ->

                            iv_dog_image.load(imageUrl)
                        }
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Error Occurred: ${response.message()}",
                            Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity,
                        "Error Occurred: ${e.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun getMydata() {
        val retrofitbuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitbuilder.getData()
        retrofitData.enqueue(object : Callback<List<Names>?> {
            override fun onResponse(call: Call<List<Names>?>, response: Response<List<Names>?>) {
                val responseBody = response.body()!!
                val mystringbuilder = StringBuilder()
                for(mydata in responseBody)
                {
                    mystringbuilder.append(mydata.message)
                }
            }

            override fun onFailure(call: Call<List<Names>?>, t: Throwable) {

            }
        })
    }
}
