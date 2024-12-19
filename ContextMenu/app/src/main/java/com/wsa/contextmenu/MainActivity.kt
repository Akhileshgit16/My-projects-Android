package com.wsa.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var contextBtn: Button
    lateinit var titleText: TextView
    lateinit var parentLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //loading views
        contextBtn = findViewById(R.id.context_btn)
        titleText = findViewById(R.id.title_tv)
        parentLayout = findViewById(R.id.main)


        registerForContextMenu(contextBtn)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateContextMenu(
        menus: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu, menus)

        super.onCreateContextMenu(menus, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.text_item -> {
                val txt = "Welcome to WSA"
                titleText.text = txt
                true
            }

            R.id.colour_item -> {
                contextBtn.setBackgroundColor(Color.GREEN)
                titleText.setTextColor(Color.BLUE)
                true
            }

            R.id.background_item -> {
                parentLayout.setBackgroundResource(R.drawable.baklavasweet)
                true
            }

            else -> {
                return super.onContextItemSelected(item)
            }
        }
    }
}

