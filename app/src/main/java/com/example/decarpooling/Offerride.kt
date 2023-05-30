package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Offerride : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offerride)
        val buttoncli=findViewById<Button>(R.id.mapbtn)
        buttoncli.setOnClickListener{
            val inte1= Intent(this,MapsActivity::class.java)
            startActivity(inte1)
        }
    }
}