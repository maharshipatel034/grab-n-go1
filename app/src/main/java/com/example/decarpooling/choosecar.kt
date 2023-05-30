package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class choosecar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosecar)
        val buttoncli=findViewById<Button>(R.id.btn1)
        buttoncli.setOnClickListener{
            val inte1= Intent(this,Offerride::class.java)
            startActivity(inte1)
        }
        val buttonclic=findViewById<Button>(R.id.btn2)
        buttonclic.setOnClickListener{
            val inte1= Intent(this,getride::class.java)
            startActivity(inte1)
        }
    }
}