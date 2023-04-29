package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class signinactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val buttonclick1=findViewById<Button>(R.id.signinbtn)
        buttonclick1.setOnClickListener{
            val inten1= Intent(this,WelcomePage::class.java)
            startActivity(inten1)
        }
    }
}