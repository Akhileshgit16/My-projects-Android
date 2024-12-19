package com.wsa.sqlitedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Initializing variables
   private lateinit var nameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var columnIdEdit: EditText
    private lateinit var deleteBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var loadBtn: Button
    private lateinit var saveBtn: Button
    private lateinit var dbHelper :DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading Views into Activity
        nameEdit = findViewById(R.id.name_et)
        emailEdit = findViewById(R.id.email_et)
        columnIdEdit = findViewById(R.id.ColumnId_et)
        phoneEdit = findViewById(R.id.phone_et)
        deleteBtn = findViewById(R.id.delete_btn)
        updateBtn = findViewById(R.id.update_btn)
        loadBtn = findViewById(R.id.load_btn)
        saveBtn = findViewById(R.id.save_btn)
        //setting listeeners for buttons
        deleteBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        dbHelper = DbHelper(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if(p0!= null)
        {
            when(p0.id)
            {
                R.id.delete_btn ->
                {
                    val rows =dbHelper.deleteEmployee(columnIdEdit.text.toString())
                    if(rows > 0)
                    {
                        Toast.makeText(applicationContext,"Data Deleted sucessfully!!",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Data not Deleted!!",Toast.LENGTH_LONG).show()
                    }
                }
                R.id.update_btn ->

                        {
                            val isUpdated : Boolean = dbHelper.updateEmployee(columnIdEdit.text.toString(),
                                nameEdit.text.toString(),emailEdit.text.toString(),phoneEdit.text.toString())
                            if(isUpdated)
                            {
                                Toast.makeText(applicationContext,"Data Updated sucessfully!!",Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(applicationContext,"Data not Updated!!",Toast.LENGTH_LONG).show()
                            }

                        }
                R.id.load_btn ->

                {
                    val intent = Intent(this,EmployeesDetails::class.java)
                    startActivity(intent)
                }
                R.id.save_btn ->

                {
                    if (nameEdit.text.isNotEmpty()&&emailEdit.text.isNotEmpty() && phoneEdit.text.isNotEmpty())
                    {
                        val employee = Employee(nameEdit.text.toString(),emailEdit.text.toString(),phoneEdit.text.toString())
                        val result : Long = dbHelper.addEmployee(employee)
                        if(result > -1)
                            Toast.makeText(applicationContext,"Data Inserted sucessfully!!",Toast.LENGTH_LONG).show()
                        columnIdEdit.text.clear()
                        nameEdit.text.clear()
                        emailEdit.text.clear()
                        phoneEdit.text.clear()
                    }
                    else{
                        Toast.makeText(applicationContext,"Fill all the fields",Toast.LENGTH_LONG).show()
                    }

                }
            }
        }

    }
}