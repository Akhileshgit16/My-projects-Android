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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var pswdEt: EditText
    private lateinit var confirmpswdEt: EditText
    private lateinit var signup: Button
    private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        //loading views into activity
        nameEt = findViewById(R.id.name_et)
        emailEt = findViewById(R.id.email_et)
        pswdEt = findViewById(R.id.passwrd_et)
        confirmpswdEt = findViewById(R.id.confirmpasswrd_et)
        signup = findViewById(R.id.signup_btn)

        auth = Firebase.auth

        //listern
        signup.setOnClickListener(this)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (nameEt.text.toString().isNotEmpty() && emailEt.text.toString().isNotEmpty() &&
            pswdEt.text.toString().isNotEmpty() && confirmpswdEt.text.toString().isNotEmpty()
        ) {
            if (pswdEt.text.toString() == confirmpswdEt.text.toString()) {
                auth.createUserWithEmailAndPassword(emailEt.text.toString(), pswdEt.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Unable to signup page", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
            } else {
                Toast.makeText(
                    this,
                    " Both Password & confirm Password must match",
                    Toast.LENGTH_LONG
                ).show()
            }
            nameEt.text.clear()
            emailEt.text.clear()
            pswdEt.text.clear()
            confirmpswdEt.text.clear()
        }
    }
}