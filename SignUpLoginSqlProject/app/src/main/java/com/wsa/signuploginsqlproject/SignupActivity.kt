package com.wsa.signuploginsqlproject

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var yname: EditText
    private lateinit var numb: EditText
    private lateinit var email: EditText
    private lateinit var pswd: EditText
    private lateinit var deleteBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var loadBtn: Button
    private lateinit var saveBtn: Button
    private lateinit var dbHelper: DbHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        //loading views into activity
        yname = findViewById(R.id.name_et)
        numb = findViewById(R.id.numb_et)
        email = findViewById(R.id.mail_et)
        pswd = findViewById(R.id.pswd_et)
        deleteBtn = findViewById(R.id.delete_btn)
        updateBtn = findViewById(R.id.update_btn)
        loadBtn = findViewById(R.id.load_btn)
        saveBtn = findViewById(R.id.save_btn)
        deleteBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        dbHelper = DbHelper(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.signup_btn -> {
                    val username = findViewById<EditText>(R.id.user_et).toString()
                    val password = findViewById<EditText>(R.id.password_et).toString()

                    if (username.isEmpty() || password.isEmpty()) {

                    }

                    R.id.save_btn ->
                    {
                    }
                }
            }
        }
    }
}




