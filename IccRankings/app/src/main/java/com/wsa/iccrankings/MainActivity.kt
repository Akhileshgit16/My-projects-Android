package com.wsa.iccrankings

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
    private  lateinit var firstName_Edit : EditText
    private  lateinit var lastName_Edit: EditText
    private  lateinit var country_Edit :EditText
    private  lateinit var birthplace_Edit:EditText
    private  lateinit var role_Edit:EditText
    private  lateinit var style_Edit:EditText
    private  lateinit var iccRankingTest_Edit:EditText
    private  lateinit var iccRankingOdi_Edit:EditText
    private  lateinit var iccRankingT20_Edit:EditText
    private  lateinit var loadBtn:Button
    private lateinit var saveBtn: Button
    private lateinit var database : FirebaseDatabase
    private lateinit var databaseReference : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views into activity
        firstName_Edit = findViewById(R.id.firstName_et)
        lastName_Edit = findViewById(R.id.lastName_et)
        country_Edit = findViewById(R.id.country_et)
        birthplace_Edit = findViewById(R.id.birthdate_et)
        role_Edit = findViewById(R.id.role_et)
        style_Edit = findViewById(R.id.style_et)
        iccRankingTest_Edit = findViewById(R.id.testranking_et)
        iccRankingOdi_Edit = findViewById(R.id.odiranking_et)
        iccRankingT20_Edit = findViewById(R.id.t20ranking_et)
        loadBtn = findViewById(R.id.load_btn)
        saveBtn = findViewById(R.id.save_btn)
        //listeners
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)


        database = Firebase.database
        databaseReference = database.reference.child("Player")


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.load_btn -> {
                    val intent = Intent(this, PlayerDetails::class.java)
                    startActivity(intent)
                }

                R.id.save_btn -> {
                    if (firstName_Edit.text.toString().isNotEmpty() && lastName_Edit.text.toString()
                            .isNotEmpty() && country_Edit.text.toString().isNotEmpty()
                        && birthplace_Edit.text.toString().isNotEmpty() && role_Edit.text.toString()
                            .isNotEmpty() && style_Edit.text.toString().isNotEmpty()
                        && iccRankingTest_Edit.text.toString()
                            .isNotEmpty() && iccRankingOdi_Edit.text.toString().isNotEmpty()
                        && iccRankingT20_Edit.text.toString().isNotEmpty()
                    ) {
                        val players = PlayerData(
                            firstName_Edit.text.toString(),
                            lastName_Edit.text.toString(),
                            country_Edit.text.toString(),
                            birthplace_Edit.text.toString(),
                            role_Edit.text.toString(),
                            style_Edit.text.toString(),
                            iccRankingTest_Edit.text.toString(),
                            iccRankingOdi_Edit.text.toString(),
                            iccRankingT20_Edit.text.toString()
                        )
                        databaseReference.push().setValue(players)
                        firstName_Edit.text.clear()
                        lastName_Edit.text.clear()
                        country_Edit.text.clear()
                        birthplace_Edit.text.clear()
                        role_Edit.text.clear()
                        style_Edit.text.clear()
                        iccRankingTest_Edit.text.clear()
                        iccRankingOdi_Edit.text.clear()
                        iccRankingT20_Edit.text.clear()
                    }
                }
            }

        }
    }
}