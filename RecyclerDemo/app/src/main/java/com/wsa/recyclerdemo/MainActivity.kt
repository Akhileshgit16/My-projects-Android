package com.wsa.recyclerdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  recycler: RecyclerView
    var versionArray = arrayOf("Vanillaicecream"," Ice Cream Sandwich","Pie","Baklava","Oreo","Nougat","KitKat",
        " Ice Cream Sandwich","Pie","Baklava","Oreo","Nougat","KitKat"," Ice Cream Sandwich","Pie","Baklava","Oreo","Nougat","KitKat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading view
        recycler= findViewById(R.id.recyclerview)
        //load view
        recycler.layoutManager =LinearLayoutManager(this)
        //choose layout
        recycler.adapter= VersionsAdapter(versionArray)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}