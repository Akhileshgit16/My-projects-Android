package com.wsa.passingdata

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var value: TextView
    lateinit var homeBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        //loading values
        value= findViewById(R.id.datatextView)
        homeBtn = findViewById(R.id.home_btn)
        //listeners
        homeBtn.setOnClickListener(this)

        val myVal:String = intent.getStringExtra("mydata").toString()
        value.text = myVal



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this,MainActivity::class.java )
        startActivity(intent)
    }
}