package com.wsa.ubereats

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recycler : RecyclerView
    lateinit var UberArrayList: ArrayList<Foodclas>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.foodRecyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        UberArrayList =ArrayList()

        UberArrayList.add(Foodclas(R.drawable.margherita,"margherita pizza"))
        UberArrayList.add(Foodclas(R.drawable.burger,"chicken burger"))
        UberArrayList.add(Foodclas(R.drawable.garlicbreadpng,"garlic bread"))
        UberArrayList.add(Foodclas(R.drawable.wafflepng,"choco waffle"))
        UberArrayList.add(Foodclas(R.drawable.pancake,"pan cake"))
        UberArrayList.add(Foodclas(R.drawable.tiramisu,"choco tiramisu"))
        UberArrayList.add(Foodclas(R.drawable.stawcheesecake,"strawberry cheesecake"))
        UberArrayList.add(Foodclas(R.drawable.potato,"potato wedges"))
        UberArrayList.add(Foodclas(R.drawable.chocchipscookie,"chocochip cookies"))
        UberArrayList.add(Foodclas(R.drawable.pasta,"cheese pasta"))

        recycler.adapter= FoodAdapter(UberArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}