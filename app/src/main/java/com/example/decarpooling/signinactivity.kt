package com.example.decarpooling

//class signinactivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_in)
//
//        val buttonclick1=findViewById<Button>(R.id.signinbtn)
//        buttonclick1.setOnClickListener{
//            val inten1= Intent(this,WelcomePage::class.java)
//            startActivity(inten1)
//        }
//    }
//}
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class signinactivity : AppCompatActivity() {

    private lateinit var fullNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var signinButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        // Initialize views
        fullNameEditText = findViewById(R.id.usertxt)
        emailEditText = findViewById(R.id.mailtxt)
        phoneEditText = findViewById(R.id.phonetxt)
        signinButton = findViewById(R.id.signinbtn)

        // Set click listener for the sign-in button
        signinButton.setOnClickListener {

            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()

            if (validateInputs(fullName, email, phone)) {
                // Perform sign-in logic here
                // You can start a new activity or perform other operations
                val inten1= Intent(this,WelcomePage::class.java)
                startActivity(inten1)
            }
        }
    }

    private fun validateInputs(fullName: String, email: String, phone: String): Boolean {
        // Validate full name
        if (fullName.isEmpty()) {
            fullNameEditText.error = "Please enter your full name"
            return false
        }

        // Validate email
        if (email.isEmpty()) {
            emailEditText.error = "Please enter your email"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Please enter a valid email address"
            return false
        }

        // Validate phone number
        if (phone.isEmpty()) {
            phoneEditText.error = "Please enter your phone number"
            return false
        } else if (!Patterns.PHONE.matcher(phone).matches()) {
            phoneEditText.error = "Please enter a valid phone number"
            return false
        }else if (!Patterns.PHONE.matcher(phone).matches() || phone.length != 10) {
            phoneEditText.error = "Please enter a valid 10-digit phone number"
            return false
        }

        return true

    }
}
