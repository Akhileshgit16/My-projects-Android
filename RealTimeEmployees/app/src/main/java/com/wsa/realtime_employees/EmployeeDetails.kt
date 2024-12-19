package com.wsa.realtime_employees

import android.os.Bundle
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

class EmployeeDetails : AppCompatActivity(), ValueEventListener {
    private lateinit var recyclerView: RecyclerView
    lateinit var employeArrayLists : ArrayList<EmployeeData>
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employeedetails)
        recyclerView = findViewById(R.id.recyclerEmployee)
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeArrayLists = ArrayList()
        getEmployees()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getEmployees() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Employees")
        databaseReference.addValueEventListener(this)

    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if(snapshot.exists()){
            for(userSnapshot in snapshot.children){
                val employee= userSnapshot.getValue(EmployeeData::class.java)
                if(employee != null)
                {
                    employeArrayLists.add(employee)
                }
                //recyclerView.adapter = EmployeeAdapter(employeArrayLists)
                recyclerView.adapter = EmployeeAdapter(employeArrayLists)
            }

        }
    }

    override fun onCancelled(error: DatabaseError) {

    }
}