package com.wsa.signuploginsqlproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

   lateinit var userEt: EditText
    lateinit var pswdEt: EditText
    lateinit var signup: Button
    lateinit var signin: Button
    lateinit var DBHelp: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        DBHelp = DbHelper(this)

        //loading views into activity
        userEt = findViewById(R.id.user_et)
        pswdEt = findViewById(R.id.password_et)
        signup = findViewById(R.id.signup_btn)
        signin = findViewById(R.id.signin_btn)
        signup.setOnClickListener(this)
        signin.setOnClickListener(this)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id) {
                R.id.signup_btn -> {
                    val username = findViewById<EditText>(R.id.user_et).text.toString()
                    val password = findViewById<EditText>(R.id.password_et).text.toString()

                    if (username.isNotEmpty() && password.isNotEmpty()) {
                        val dbHelper = DbHelper(this)
                        val isInserted = dbHelper.ins(username, password)

                        if (isInserted) {
                            Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Sign-up failed. Try again.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Please fill in both fields.", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}