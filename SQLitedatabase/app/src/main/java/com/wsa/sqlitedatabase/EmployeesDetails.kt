package com.wsa.sqlitedatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EmployeesDetails : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var dbHelper: DbHelper
    lateinit var employeesArrayList: ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employees_details)
        //
        recyclerView = findViewById(R.id.recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)
        dbHelper = DbHelper(this)
        employeesArrayList = dbHelper.getEmployees()
        recyclerView.adapter = EmployeeAdapter(employeesArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}