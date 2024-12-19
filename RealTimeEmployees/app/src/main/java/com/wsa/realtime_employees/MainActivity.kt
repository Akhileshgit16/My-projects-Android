package com.wsa.realtime_employees

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Initializing variables
    private lateinit var nameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var designEdit: EditText
    private lateinit var loadBtn: Button
    private lateinit var saveBtn: Button
    // Firebase
    private lateinit var database: FirebaseDatabase
    // Firebase Reference
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views into activity
        nameEdit = findViewById(R.id.name_et)
        emailEdit = findViewById(R.id.email_et)
        phoneEdit = findViewById(R.id.phone_et)
        designEdit = findViewById(R.id.design_et)
        loadBtn = findViewById(R.id.load_btn)
        saveBtn = findViewById(R.id.save_btn)
        //listeners
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        // Initialize Firebase
        database = Firebase.database
        databaseReference = database.reference.child("Employees")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if(v != null) {
            when (v.id) {
                R.id.load_btn -> {
                    val intent = Intent(this, EmployeeDetails::class.java)
                    startActivity(intent)

                }

                R.id.save_btn -> {
                    if (nameEdit.text.toString().isNotEmpty() && emailEdit.text.toString()
                            .isNotEmpty()
                        && phoneEdit.text.toString().isNotEmpty() && designEdit.text.toString()
                            .isNotEmpty()
                    ) {
                        val employee = EmployeeData(
                            nameEdit.text.toString(), emailEdit.text.toString(),
                            phoneEdit.text.toString(), designEdit.text.toString()
                        )
                        databaseReference.push().setValue(employee)
                        nameEdit.text.clear()
                        emailEdit.text.clear()
                        phoneEdit.text.clear()
                        designEdit.text.clear()
                    }
                }
            }
        }
    }
}