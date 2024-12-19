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
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var pswdEt: EditText
    private lateinit var confirmpswdEt: EditText
    private lateinit var signup: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        nameEt = findViewById(R.id.name_et)
        emailEt = findViewById(R.id.email_et)
        pswdEt = findViewById(R.id.passwrd_et)
        confirmpswdEt = findViewById(R.id.confirmpasswrd_et)
        signup = findViewById(R.id.signup_btn)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Set listener for the signup button
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
            R.id.signup_btn -> {
                val name = nameEt.text.toString().trim()
                val email = emailEt.text.toString().trim()
                val password = pswdEt.text.toString()
                val confirmPassword = confirmpswdEt.text.toString().trim()

                // Validate input fields
                if (name.isEmpty()) {
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                    return
                }

                if (email.isEmpty()) {
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                    return
                }

                if (password.isEmpty()) {
                    Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
                    return
                }

                if (confirmPassword.isEmpty()) {
                    Toast.makeText(this, "Please confirm your password", Toast.LENGTH_SHORT).show()
                    return
                }

                // Check if passwords match
                if (password != confirmPassword) {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    return
                }

                // Create a new user with email and password
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Redirect to SignInActivity if signup is successful
                            val signInIntent = Intent(this, SignInActivity::class.java)
                            startActivity(signInIntent)
                            finish() // Close the current activity to prevent back navigation
                        } else {
                            // Handle specific Firebase error cases
                            val exception = task.exception
                            when (exception) {
                                is FirebaseAuthUserCollisionException -> {
                                    Toast.makeText(this, "This email is already in use", Toast.LENGTH_LONG).show()
                                }
                                is FirebaseAuthWeakPasswordException -> {
                                    Toast.makeText(this, "Password is too weak. Please use a stronger password", Toast.LENGTH_LONG).show()
                                }
                                else -> {
                                    Toast.makeText(this, "Unable to Sign Up: ${exception?.message}", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(this, "Sign-up failed: ${exception.message}", Toast.LENGTH_LONG).show()
                    }
            }
        }
    }
}
