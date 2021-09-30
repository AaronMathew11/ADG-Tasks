package com.example.datepicker

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import java.time.DayOfWeek
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pick = findViewById<Button>(R.id.pick)
        val edit   = findViewById<TextView>(R.id.edit)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pick.setOnClickListener {
            val calendar = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                edit.setText("" + dayOfMonth + "/" + month + "/" + year)
            }, year, month, day)
            calendar.show()
        }
        val name:EditText=findViewById(R.id.name)
        val pass:EditText=findViewById(R.id.pass)
        val btn:Button=findViewById(R.id.btn)

        btn.setOnClickListener {
        if(name.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            Toast.makeText(applicationContext,"Welcome "+ name.text,Toast.LENGTH_LONG).show()
            val alert = AlertDialog.Builder(this)
            val dview = layoutInflater.inflate(R.layout.alert,null)
            alert.setView(dview)
            alert.show()
        }
        else
        {
            val snack= Snackbar.make(it,"Please fill in the required details!",Snackbar.LENGTH_INDEFINITE)
            snack.setAction("close",View.OnClickListener{
                snack.dismiss()
            })
            snack.show()
        }
     }

    }
}