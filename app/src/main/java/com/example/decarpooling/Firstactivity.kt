package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class Firstactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonclick=findViewById<Button>(R.id.signUpBtn)
        buttonclick.setOnClickListener{
            val inten=Intent(this,signinactivity::class.java)
            startActivity(inten)
        }
        val buttonclick1=findViewById<Button>(R.id.loginbtn)
        buttonclick1.setOnClickListener{
            val inten1=Intent(this,LoginActivity::class.java)
            startActivity(inten1)
        }
    }
}
