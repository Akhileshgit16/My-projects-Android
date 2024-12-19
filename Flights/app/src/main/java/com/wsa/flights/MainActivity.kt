package com.wsa.flights

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
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var emirates: Button
        lateinit var lufthasna: Button
        lateinit var british: Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        emirates = findViewById(R.id.emitares_btn)
        lufthasna = findViewById(R.id.Lufthansa_btn)
        british = findViewById(R.id.British_btn)
        //setting listerners
        emirates.setOnClickListener(this)
        lufthasna.setOnClickListener(this)
        british.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(View: View?) {
        if (View != null) {
            when (View.id) {
                R.id.emitares_btn -> {
                    val emirateintent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.emirates.com/in/english/")
                    )
                    startActivity(emirateintent)
                }

                R.id.Lufthansa_btn -> {
                    val lufthanintent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.lufthansa.com/in/en/homepage")
                    )
                    startActivity(lufthanintent)
                }

                R.id.British_btn -> {
                    val britishintent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.britishairways.com/travel/home/public/en_us/")
                    )
                    startActivity(britishintent)
                }
            }
        }
    }
}