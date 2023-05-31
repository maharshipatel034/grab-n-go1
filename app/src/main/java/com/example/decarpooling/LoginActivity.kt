package com.example.decarpooling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        userNameEditText = findViewById(R.id.usertxt)
        passwordEditText = findViewById(R.id.passtxt)
        loginButton = findViewById(R.id.logbtn)

        // Set click listener for the login button
        loginButton.setOnClickListener {
            val userName = userNameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInputs(userName, password)) {
                // Perform login logic here
                // You can start a new activity or perform other operations
                val intent = Intent(this, WelcomePage::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateInputs(userName: String, password: String): Boolean {
        // Validate username
        if (userName.isEmpty()) {
            userNameEditText.error = "Please enter your username"
            return false
        }

        // Validate password
        if (password.isEmpty()) {
            passwordEditText.error = "Please enter your password"
            return false
        }

        return true
    }
}

//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        val buttonclic = findViewById<Button>(R.id.logbtn)
//        buttonclic.setOnClickListener {
//            val inte1 = Intent(this, WelcomePage::class.java)
//            startActivity(inte1)
//        }
//
//    }
//}
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