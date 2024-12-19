package com.wsa.implicitintents
import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var call: Button
    lateinit var dial: Button
    lateinit var browse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //loading views into activity
        call = findViewById(R.id.call_btn)
        dial = findViewById(R.id.dail_btn)
        browse = findViewById(R.id.browse_btn)
        //setting listerners
        call.setOnClickListener(this)
        dial.setOnClickListener(this)
        browse.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.call_btn -> {
                    val callintent = Intent(Intent.ACTION_CALL, Uri.parse("tel:9502192222"))
                    startActivity(callintent)
                    }
                R.id.dail_btn ->{
                    val dialintent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:124121413"))
                    startActivity(dialintent)
                }
                R.id.browse_btn -> {
                    val browseintent = Intent (Intent.ACTION_VIEW, Uri.parse("https://www.cricbuzz.com/cricket-series/ipl-2025/auction/completed"))
                    startActivity(browseintent)
                }
            }
        }
    }
}