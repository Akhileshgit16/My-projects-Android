package com.wsa.multi_button

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //declare
    lateinit var image: ImageView
    lateinit var morning_btn: Button
    lateinit var evening_btn: Button
    lateinit var night_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize the ImageView and Buttons
        val main : ConstraintLayout = findViewById(R.id.main)
        image= findViewById(R.id.morning_iv)
        morning_btn = findViewById(R.id.gmorning_bt)
        evening_btn = findViewById(R.id.gevening_bt)
        night_btn = findViewById(R.id.gnight_bt)

        // Set OnClickListener for morning
        morning_btn.setOnClickListener {
            // Change the image in the ImageView to image1 when button1 is clicked
            image.setImageResource(R.drawable.morning)  // Replace with your image resource
        }

        // Set OnClickListener for evening
        evening_btn.setOnClickListener {
            // Change the image in the ImageView to image2 when button2 is clicked
            image.setImageResource(R.drawable.evening)  // Replace with your image resource
        }
        // Set OnClickListener for night
        night_btn.setOnClickListener {
            // Change the image in the ImageView to image2 when button2 is clicked
            image.setImageResource(R.drawable.night)  // Replace with your image resource
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}