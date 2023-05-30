package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class getride : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getride)
        val buttoncli=findViewById<Button>(R.id.mapbtn)
        buttoncli.setOnClickListener{
            val inte1= Intent(this,MapsActivity::class.java)
            startActivity(inte1)
        }
        val buttonclic=findViewById<Button>(R.id.search)
        buttonclic.setOnClickListener{
            val inte2= Intent(this,Mapselectplace::class.java)
            startActivity(inte2)
        }
    }
}