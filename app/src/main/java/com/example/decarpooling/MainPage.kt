package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        val buttoncli=findViewById<ToggleButton>(R.id.searchCreateButton1)
        buttoncli.setOnClickListener{
            val inte1= Intent(this,MapsActivity::class.java)
            startActivity(inte1)
        }

    }
}