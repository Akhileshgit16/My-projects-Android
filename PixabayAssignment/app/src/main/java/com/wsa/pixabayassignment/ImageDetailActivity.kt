package com.wsa.pixabayassignment

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class ImageDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_detail)

        val imageUrl = intent.getStringExtra("IMAGE_URL")?:""
        val userName = intent.getStringExtra("username")?:"Unknown"
        val like = intent.getIntExtra("likes", 0)
        val view = intent.getIntExtra("views",0)
        val download = intent.getIntExtra("downloads",0)

        // Log the data to check if it's received correctly
        Log.d("ImageDetailActivity", "Received Image URL: $imageUrl")
        Log.d("ImageDetailActivity", "Received Username: $userName")
        Log.d("ImageDetailActivity", "Received Likes: $like")
        Log.d("ImageDetailActivity", "Received Views: $view")
        Log.d("ImageDetailActivity", "Received Downloads: $download")

        val imageView : ImageView = findViewById(R.id.imageViewDetail)
        val usernameTextview :TextView =findViewById(R.id.userTextViewDetail)
        val likesTextview :TextView =findViewById(R.id.likesTextViewDetail)
        val viewsTextview :TextView =findViewById(R.id.viewsTextViewDetail)
        val downloadsTextview :TextView =findViewById(R.id.downloadsTextViewDetail)

        Picasso.get().load(imageUrl).into(imageView)
        usernameTextview.text = "User: $userName"
        likesTextview.text = "Likes: $like"
        viewsTextview.text = "Views: $view"
        downloadsTextview.text = "Downloads: $download"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}