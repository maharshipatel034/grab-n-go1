package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
//        val buttonclic=findViewById<Button>(R.id.openProfileInfoButton)
//        buttonclic.setOnClickListener {
//            val inte = Intent(this, MainPage::class.java)
//            startActivity(inte)
//        }}
        val buttonclic=findViewById<Button>(R.id.openProfileInfoButton)
        buttonclic.setOnClickListener {
            val inte = Intent(this, choosecar::class.java)
            startActivity(inte)
        }}

}