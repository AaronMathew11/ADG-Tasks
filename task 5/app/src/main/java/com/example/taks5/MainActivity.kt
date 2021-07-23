package com.example.taks5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun stageone(view: View) {
        val intent = Intent(this,options::class.java)
        startActivity(intent)
        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        finish()
    }
    fun stagethree(view: View) {
        startActivity(Intent(this,people::class.java))
        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        finish()
    }
    fun stagetwo(view: View) {
        startActivity(Intent(this,pets::class.java))
        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        finish()
    }
}