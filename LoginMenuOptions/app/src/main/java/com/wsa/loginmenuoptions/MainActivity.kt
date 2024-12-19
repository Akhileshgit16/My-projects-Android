package com.wsa.loginmenuoptions

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var menusRecyclerView: RecyclerView
    private val menuArrayList = ArrayList<menuData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enabling edge-to-edge support for the activity
        enableEdgeToEdge()

        setContentView(R.layout.menualerts)

        // Initializing the RecyclerView
        menusRecyclerView = findViewById(R.id.menurecyclerView)
        menusRecyclerView.layoutManager = LinearLayoutManager(this)

        // Setting the adapter for RecyclerView
        menusRecyclerView.adapter = FoodAdapter(menuArrayList)

        // Handling window insets for edge-to-edge content
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Inflating the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    // Handling menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_Btn -> {
                startActivity(Intent(this, MenuAlerts::class.java))
                // Show the custom alert dialog when the add button is clicked
                MenuAlerts().show(supportFragmentManager, "menu_alerts")
                true
            }
            else -> {
                // Default behavior for other items
                super.onOptionsItemSelected(item)
            }
        }
    }
}
