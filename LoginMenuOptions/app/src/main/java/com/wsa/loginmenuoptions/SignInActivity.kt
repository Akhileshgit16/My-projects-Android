package com.wsa.loginmenuoptions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class SignInActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userEt: EditText
    lateinit var passwordEt: EditText
    lateinit var signin: Button
    lateinit var signup: Button

    // Firebase authentication instance
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Initialize views
        userEt = findViewById(R.id.user_edittext)
        passwordEt = findViewById(R.id.password_edittext)
        signin = findViewById(R.id.signin_btn)
        signup = findViewById(R.id.signup_button)

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Set onClickListeners
        signin.setOnClickListener(this)
        signup.setOnClickListener(this)

        // Handling window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signin_btn -> {
                val username = userEt.text.toString().trim() // .trim() removes spaces
                val password = passwordEt.text.toString().trim()

                // Validate inputs
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_LONG).show()
                    return
                }

                // Sign in with email and password
                auth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Redirect to MainActivity if login is successful
                            val signInIntent = Intent(this, MainActivity::class.java)
                            startActivity(signInIntent)

                            // Close this activity to prevent back navigation
                            finish()
                        } else {
                            // Handle login failure with specific error message
                            val exception = task.exception
                            val errorMessage = when (exception) {
                                is FirebaseAuthInvalidUserException -> "Invalid username or email."
                                is FirebaseAuthInvalidCredentialsException -> "Invalid password."
                                else -> "Authentication failed. Please try again."
                            }
                            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
            }

            R.id.signup_button -> {
                // Redirect to SignUpActivity for registration
                val signupIntent = Intent(this, SignUpActivity::class.java)
                startActivity(signupIntent)
            }
        }
    }
}
