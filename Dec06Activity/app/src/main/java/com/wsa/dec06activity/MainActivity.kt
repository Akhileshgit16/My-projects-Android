package com.wsa.dec06activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.PixelCopy.Request
import android.view.View
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuAdapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), View.OnClickListener, ValueEventListener {


    private lateinit var menusRecyclerView: RecyclerView
    private lateinit var menuAdapter: Adapter
    private lateinit var addbtn: Button
    private lateinit var menuList: ArrayList<menuItems>

    //databaserefer
    private lateinit var databasereference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        addbtn = findViewById(R.id.btnAddItem)
        addbtn.setOnClickListener(this)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.menurecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MenuAdapter(menuList)

        menuList = ArrayList()


        getfooditems()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getfooditems() {
         databasereference = FirebaseDatabase.getInstance().getReference("menu")
        databasereference.addValueEventListener(this)
    }


    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item -> {
                val menuIntent = Intent(this, MenuItemsActivity::class.java)
                startActivity(menuIntent)
                true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if(snapshot.exists()){
          for(usersnap in snapshot.children){
              val fooditem =usersnap.getValue(menuItems::class.java)
              if(fooditem!= null)
              {
                 menuList.add(menuItems)
              }
          }

        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}