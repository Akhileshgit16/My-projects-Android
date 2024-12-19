package com.wsa.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.core.content.contentValuesOf
import java.security.Key

class DbHelper(context: Context):SQLiteOpenHelper(context,Database_Name,null, Database_Version) {
    companion object {
        const val Database_Name = "employees.db"
        const val Database_Version = 1
        const val Database_Table = "Emp_table"
        const val Key_ID = "ID"
        const val Key_Name = "Name"
        const val Key_Email = "Email"
        const val Key_Phone = "Phone"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "create table $Database_Table ($Key_ID INTEGER PRIMARY KEY AUTOINCREMENT,$Key_Name TEXT,$Key_Email TEXT,$Key_Phone TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(Db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Db!!.execSQL("drop table if exists $Database_Table")
        onCreate(Db)
    }
    fun addEmployee(employee: Employee):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Key_Name,employee.name)
        contentValues.put(Key_Email,employee.email)
        contentValues.put(Key_Phone,employee.phone)
        return db.insert(Database_Table,null,contentValues)
    }
    fun getEmployees():ArrayList<Employee>{
        val employeeArrayList: ArrayList<Employee> =ArrayList()
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $Database_Table",null)
        while (cursor.moveToNext()) {
            val name =cursor.getString(1)
            val email =cursor.getString(2)
            val phone =cursor.getString(3)
            employeeArrayList.add(Employee(name,email,phone))
        }
        cursor.close()
        db.close()
        return employeeArrayList
    }
    fun updateEmployee(id:String,name:String,emailid:String,phone: String):Boolean
    {
        val db =writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Key_ID,id)
        contentValues.put(Key_Name,name)
        contentValues.put(Key_Email,emailid)
        contentValues.put(Key_Phone,phone)
        db.update(Database_Table,contentValues,"$Key_ID=?", arrayOf(id))
        return true
    }

    fun deleteEmployee(id:String)  : Int{
        val db =writableDatabase
        return  db.delete(Database_Table,"$Key_ID=?", arrayOf(id))

    }


}