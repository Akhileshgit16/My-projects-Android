package com.wsa.iccrankings

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class PlayerDetails : AppCompatActivity(), ValueEventListener {
    lateinit var recyclerView: RecyclerView
    lateinit var playersArrayList: ArrayList<PlayerData>
    lateinit var dataReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_player_details)

        recyclerView = findViewById(R.id.playersRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        playersArrayList = ArrayList()
        getPlayers()
        //set adaptor
        recyclerView.adapter = PlayersAdapter(playersArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getPlayers() {
        dataReference = FirebaseDatabase.getInstance().getReference("Player")
        dataReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            playersArrayList.clear()  // Clear the list before adding new data
            for (playerSnapshot in snapshot.children) {
                val player = playerSnapshot.getValue(PlayerData::class.java)
                if (player != null) {
                    playersArrayList.add(player)
                }
            }
            if (playersArrayList.isEmpty()) {
                Toast.makeText(this, "No players found", Toast.LENGTH_SHORT).show()
            }
            recyclerView.adapter = PlayersAdapter(playersArrayList)
        }
    }


    override fun onCancelled(error: DatabaseError) {

    }
}