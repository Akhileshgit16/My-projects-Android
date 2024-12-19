package com.wsa.sharedpreferences

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
    lateinit var nameEdittext : EditText
    lateinit var passwordEdittext : EditText
    lateinit var loadButton : Button
    lateinit var saveButton : Button
    lateinit var sharedPrefes : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
         // loading views into activity
        nameEdittext = findViewById(R.id.name_et)
        passwordEdittext = findViewById(R.id.password_et)
        loadButton = findViewById(R.id.load_btn)
        saveButton = findViewById(R.id.submit_btn)

        //setting listeners
        loadButton.setOnClickListener(this)
        saveButton.setOnClickListener(this)
        sharedPrefes = getSharedPreferences("WSA", MODE_PRIVATE)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if(v != null)
        {
            when(v.id) {
                R.id.submit_btn -> {
                    val editor: SharedPreferences.Editor = sharedPrefes.edit()
                    editor.putString("nameKey", nameEdittext.text.toString())
                    editor.putString("passKey", passwordEdittext.text.toString())
                    editor.apply()
                    nameEdittext.text.clear()
                    passwordEdittext.text.clear()
                }

                R.id.load_btn -> {
                    if(sharedPrefes.contains("nameKey"))
                    {
                        nameEdittext.setText(sharedPrefes.getString("nameKey",""))
                    }
                    else
                    {
                        Toast.makeText(this,"Empty Preference",Toast.LENGTH_LONG).show()
                    }
                    if (sharedPrefes.contains("passKey"))
                    {
                        passwordEdittext.setText(sharedPrefes.getString("passKey",""))
                    }
                    else
                    {
                        Toast.makeText(this,"Empty Preference",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}