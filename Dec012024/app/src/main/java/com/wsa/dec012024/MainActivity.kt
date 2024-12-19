package com.wsa.dec012024

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lateinit var recycler : RecyclerView
        lateinit var FoodArrayList: ArrayList<Foods>

        /*
        recycler = findViewById(R.id.foodRecyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        UberArrayList =ArrayList()
        UberArrayList.add(Food(R.drawable.pizzapng,"Pizza"))
        UberArrayList.add(Food(R.drawable.burgerpng,"Burger"))
        UberArrayList.add(Food(R.drawable.donoutpng,"Doughnut"))
        UberArrayList.add(Food(R.drawable.garlicbreadpng,"Garlic-Bread"))
        UberArrayList.add(Food(R.drawable.wafflepng,"Choco-Waffle"))
        UberArrayList.add(Food(R.drawable.pancake,"Pan-Cake"))
        UberArrayList.add(Food(R.drawable.tiramisu,"Tiramisu"))
        UberArrayList.add(Food(R.drawable.chickenfries,"Chicken-Fries"))
        UberArrayList.add(Food(R.drawable.stawcheesecake,"Straberry Cheese-Cake"))
        UberArrayList.add(Food(R.drawable.potato,"Potato Wedges"))
        UberArrayList.add(Food(R.drawable.pasta,"Pasta"))
        recycler.adapter= FoodAdapter(UberArrayList)   */


        //load views
        recyclerView =findViewById(R.id.recyclerimageview)
        //load layot
        recyclerView.layoutManager= GridLayoutManager(this,4)
        //
        recyclerView.adapter = VersionImageadapter(versionimageArray)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}