package com.example.retrofit

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recycler_adapter (val context: Context, val userList : List<Names>): RecyclerView.Adapter<recycler_adapter.ViewHolder>(){



    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var userId : TextView
        var title : TextView
        int{
            userId=itemView.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}