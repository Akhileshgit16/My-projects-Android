package com.wsa.rideapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    //initialization
    lateinit var pickTv: TextView
    lateinit var destTv: TextView
    lateinit var travelTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        //loading views into activity
        pickTv =findViewById(R.id.pickup_tv)
        destTv= findViewById(R.id.dest_tv)
        travelTv = findViewById(R.id.travel_tv)

        //// Get the data passed from MainActivity
        val pickUp = intent.getStringExtra("pickup").toString()
        val desT = intent.getStringExtra("Dest").toString()
        val travel1 = intent.getStringExtra("Date").toString()
        val travel2 = intent.getStringExtra("Time").toString()

        // Set the received data in the TextViews
        pickTv.text = "Pick Up : $pickUp"
        destTv.text = "Destination : $desT"
        travelTv.text = "Travel_date_time : $travel1 , $travel2"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}