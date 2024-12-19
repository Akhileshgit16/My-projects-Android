package com.wsa.signing

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
    lateinit var yname: EditText
    lateinit var numb: EditText
    lateinit var email: EditText
    lateinit var pswd: EditText
    lateinit var signupbtn: Button
    lateinit var sharedPrefes: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        //loading views into activity
        yname = findViewById(R.id.name_et)
        numb = findViewById(R.id.numb_et)
        email = findViewById(R.id.mail_et)
        pswd = findViewById(R.id.pswd_et)
        signupbtn = findViewById(R.id.signup_btn)
        signupbtn.setOnClickListener(this)
        sharedPrefes = getSharedPreferences("usepref", MODE_PRIVATE)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v1: View?) {
        if (v1 != null) {
            when (v1.id) {
                R.id.signup_btn -> {
                    val editor: SharedPreferences.Editor = sharedPrefes.edit()
                    editor.putString("nameKey", yname.text.toString())
                    editor.putString("number", numb.text.toString())
                    editor.putString("emailid", email.text.toString())
                    editor.putString("passKey", pswd.text.toString())
                    editor.apply()
                    yname.text.clear()
                    numb.text.clear()
                    email.text.clear()
                    pswd.text.clear()


                }
            }
        }
    }
}

