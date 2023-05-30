package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
//        val buttoncli=findViewById<ToggleButton>(R.id.searchCreateButton1)
//        buttoncli.setOnClickListener{
//            val inte1= Intent(this,MapsActivity::class.java)
//            startActivity(inte1)
//        }
        val Buttontog = findViewById<ToggleButton>(R.id.driverPassengerToggle)
        val ToggleButtonState = Buttontog.isChecked
        if(ToggleButtonState)
        {
            val buttoncli=findViewById<ToggleButton>(R.id.searchCreateButton1)
            buttoncli.setOnClickListener{
                val inte1= Intent(this,Offerride::class.java)
                startActivity(inte1)
            }
        }
        else{
            val buttoncli=findViewById<ToggleButton>(R.id.searchCreateButton1)
            buttoncli.setOnClickListener{
                val inte1= Intent(this,getride::class.java)
                startActivity(inte1)
            }
        }
    }
}