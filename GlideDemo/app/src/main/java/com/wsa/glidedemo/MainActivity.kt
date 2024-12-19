package com.wsa.glidedemo

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var image1:ImageView
    lateinit var image2:ImageView
    lateinit var image3:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        image1=findViewById(R.id.display_iv)
        image2 = findViewById(R.id.display_iv2)
        image3 = findViewById(R.id.display_i3)
        Glide.with(this).load("https://images.news9live.com/wp-content/uploads/2024/08/Virat-Kohli-5.jpg?w=1200&enlarge=true").into(image1)
        Glide.with(this).load("https://cf-img-a-in.tosshub.com/sites/visualstory/wp/2023/12/virat-anushka-5.jpg?size=*:900").into(image2)
        Glide.with(this).load("https://static.india.com/wp-content/uploads/2024/02/Virat-Kohli-with-Vamika-Kohli.jpg?impolicy=Medium_Resize&w=1200&h=800").into(image3)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}