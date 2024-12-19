package com.wsa.pixabayassignment

import PixabayService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Fetch data from API
        fetchImages()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun fetchImages() {
        val apiKey = "47653851-be8efc99633a4a71764951148"
        val service = Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayService::class.java)

        service.getImages(apiKey, "car", "photo")
            .enqueue(object : Callback<PixabayResponse> {
                override fun onResponse(
                    call: Call<PixabayResponse>,
                    response: Response<PixabayResponse>
                ) {
                    if (response.isSuccessful) {
                        val images = response.body()?.hits ?: emptyList()
                        Log.d("MainActivity", "Images fetched: ${images.size}")

                        imageAdapter = ImageAdapter(images) { imageData ->
                            // Navigate to the next screen with image details
                            val intent = Intent(applicationContext, ImageDetailActivity::class.java)
                            intent.putExtra("IMAGE_URL", imageData.largeImageURL)
                            intent.putExtra("username", imageData.username)
                            intent.putExtra("likes", imageData.likes)
                            intent.putExtra("views", imageData.views)
                            intent.putExtra("downloads", imageData.downloads)
                            startActivity(intent)
                        }
                        recyclerView.adapter = imageAdapter
                    }
                }

                override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                    // Handle failure
                }
            })
    }
}
