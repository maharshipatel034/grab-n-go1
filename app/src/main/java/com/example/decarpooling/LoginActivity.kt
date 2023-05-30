package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonclic = findViewById<Button>(R.id.logbtn)
        buttonclic.setOnClickListener {
            val inte1 = Intent(this, WelcomePage::class.java)
            startActivity(inte1)
        }

    }
}
//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        val buttonClick = findViewById<Button>(R.id.logbtn)
//        buttonClick.setOnClickListener {
//            navigateToNavigationPage()
//        }
//    }
//
//    private fun navigateToNavigationPage() {
//        val intent = Intent(this, NavigatoinsBottom::class.java)
//        startActivity(intent)
//    }
//}