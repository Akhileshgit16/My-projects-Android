package com.wsa.passingdata

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var dataEdittxt: EditText
    lateinit var sendButn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        dataEdittxt = findViewById(R.id.data_et)
        sendButn = findViewById(R.id.send_btn)

        //setting listner for button
        sendButn.setOnClickListener(this,)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onClick(p0: View?) {
        val intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("mydata",dataEdittxt.text.toString())
        startActivity(intent)
    }
}