package com.wsa.jsondemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject



class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var employeeAray: ArrayList<Employees>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeeAray= ArrayList()

        //create json object
        val jsonOject = JSONObject(loadJSONFromAsset())
        val empArray = jsonOject.getJSONArray("employees")
        for (emp in 0 until empArray.length()) {
            val empObject = empArray.getJSONObject(emp)
            val nameVal = empObject.getString("name")
            val emailVal = empObject.getString("email")
            val phoneVal = empObject.getString("phone")
            employeeAray.add(Employees(nameVal, emailVal, phoneVal))
        }

        //create adapter object
        recyclerView.adapter = EmployeeAdapter(employeeAray)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadJSONFromAsset(): String {

        val inputStream = assets.open("employe.json")
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer)
        return json
    }
}
