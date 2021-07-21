package com.example.dogbreedapp

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecyclerAdapter(context: MainActivity, var names: Array<String>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var context: Context
    var url = ""
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View =
            layoutInflater.inflate(R.layout.custom_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val retrofit: Retrofit = Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val imageApi: ImageApi = retrofit.create(ImageApi::class.java)
        val call: Call<Images> = imageApi.getImage(names[position])
        call.enqueue(object : Callback<Images?>() {
            fun onResponse(call: Call<Images?>?, response: Response<Images?>) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code())
                    return
                }
                val images: Images = response.body()
                url = images.url
                Picasso.with(context).load(url).into(holder.imageView)
                println("Inside $url")
            }

            fun onFailure(call: Call<Images?>?, t: Throwable) {
                println("Error : $t")
            }
        })
        holder.breed.text = names[position]
        println(names[position])
        println(url)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var breed: TextView
        var imageView: ImageView

        init {
            breed = itemView.findViewById(R.id.breed)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    init {
        //System.out.println(url);
        //System.out.println(names);
        this.context = context
    }
}