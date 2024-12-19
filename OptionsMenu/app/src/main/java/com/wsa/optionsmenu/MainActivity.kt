package com.wsa.optionsmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.virat -> {
                val vkintent = Intent(this,ViratActivity::class.java)
                startActivity(vkintent)
                true
            }
            R.id.rohit -> {
                val rohintent = Intent(this,RohitActivity::class.java)
                startActivity(rohintent)
                true
            }
            R.id.dhoni -> {
                val dhointent = Intent(this,DhoniActivity::class.java)
                startActivity(dhointent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }









        /*
        return when (item.itemId) {
            R.id.call -> {
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel: 91655836"))
                startActivity(callIntent)
                true
            }

            R.id.launch -> {
                val newIntent = Intent(this,OptionsActivity::class.java)
                startActivity(newIntent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }  */

}

