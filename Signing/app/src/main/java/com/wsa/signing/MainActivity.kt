package com.wsa.signing

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var userEt: EditText
    lateinit var pswdEt: EditText
    lateinit var signup: Button
    lateinit var signin: Button
    lateinit var sharepref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //loading views into activity
        userEt = findViewById(R.id.user_et)
        pswdEt = findViewById(R.id.password_et)
        signup = findViewById(R.id.signup_btn)
        signin = findViewById(R.id.signin_btn)
        signup.setOnClickListener(this)
        signin.setOnClickListener(this)
        sharepref = getSharedPreferences("usepref", MODE_PRIVATE)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                // Handle the Sign In button
                R.id.signin_btn -> {
                    val storedUsername = sharepref.getString("nameKey", null)
                    val storedPassword = sharepref.getString("passKey", null)

                    // If no stored credentials are found
                    if (storedUsername == null || storedPassword == null) {
                        Toast.makeText(
                            this,
                            "No user data found. Please sign up.",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        // Get entered username and password
                        val enteredUsername = userEt.text.toString()
                        val enteredPassword = pswdEt.text.toString()

                        // If entered credentials match the stored ones
                        if (enteredUsername == storedUsername && enteredPassword == storedPassword) {
                            // If credentials match, proceed to WelcomeActivity
                            val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                            startActivity(welcomeIntent)
                        }
                        // If entered credentials do not match
                        else if (enteredUsername != storedUsername || enteredPassword != storedPassword) {
                            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }

                // Handle the Sign Up button
                R.id.signup_btn -> {
                    val enteredUsername = userEt.text.toString()
                    val enteredPassword = pswdEt.text.toString()

                    // Check if fields are empty
                    if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                        Toast.makeText(
                            this,
                            "Please fill both username and password",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Save new user credentials to SharedPreferences
                        val editor = sharepref.edit()
                        editor.putString("nameKey", enteredUsername)
                        editor.putString("passKey", enteredPassword)
                        editor.apply()


                        // Navigate to SignupActivity after successful sign-up
                        val signupIntent = Intent(this, SignupActivity::class.java)
                        startActivity(signupIntent)

                        Toast.makeText(
                            this,
                            "Sign Up successful! Please Sign In.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}



                /*
        if(view!=null)
        {
            when (view.id){
                R.id.signup_btn -> {
                    val sintent= Intent(this,SignupActivity::class.java)
                    startActivity(sintent)
                }
                R.id.signin_btn -> {
                    if (userEt.text.toString().isEmpty() || pswdEt.text.toString().isEmpty())
                    {
                        Toast.makeText(this,"Please enter username and password", Toast.LENGTH_LONG).show()
                    }
                    else if (userEt.text.toString() == "admin" && pswdEt.text.toString() == "admin")
                    {
                        val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                        startActivity(welcomeIntent)
                    }
                    else
                    {
                        Toast.makeText(this,"Invalid Details", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        */

