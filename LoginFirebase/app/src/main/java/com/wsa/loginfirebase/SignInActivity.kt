package com.wsa.loginfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userEt: EditText
    lateinit var passwordEt: EditText
    lateinit var signin: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        //loading views into activity
        userEt = findViewById(R.id.user_edittext)
        passwordEt = findViewById(R.id.password_edittext)
        signin = findViewById(R.id.signin_btn)
        //authentication initialiazation
        auth = Firebase.auth

        signin.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val username = userEt.text.toString()
        val password = passwordEt.text.toString()
        auth.signInWithEmailAndPassword(username,password).addOnCompleteListener {
            if(it.isSuccessful)
            {
             val intent = Intent(this,WelcomeActivity::class.java)
             startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Invalid Username or Password",Toast.LENGTH_LONG).show()
            }
        }

    }
}