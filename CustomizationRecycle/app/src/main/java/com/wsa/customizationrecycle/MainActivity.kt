package com.wsa.customizationrecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recycler :RecyclerView
    lateinit var versionArrayList: ArrayList<Version>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        versionArrayList =ArrayList()
        versionArrayList.add(Version(R.drawable.sweet,"sweet"))
        versionArrayList.add(Version(R.drawable.donout,"donout"))
        versionArrayList.add(Version(R.drawable.icecream_sandwich,"icecream sandwich"))
        versionArrayList.add(Version(R.drawable.baklavasweet,"baklawa"))
        
        recycler.adapter = VersionNameAdapter(versionArrayList)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



}