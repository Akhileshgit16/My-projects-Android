package com.wsa.signuploginsqlproject

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
        const val Database_Name = "UserDB"
        const val Database_Version = 1
        const val Database_Table = "Users_table"
        const val Key_ID = "ID"
        const val Key_Name = "Name"
        const val Key_Phone = "Phone"
        const val Key_Email = "Email"
        const val Key_Password = "Password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "create table $Database_Table ($Key_ID INTEGER PRIMARY KEY AUTOINCREMENT,$Key_Name TEXT,$Key_Phone TEXT,$Key_Email TEXT" +
                    ",$Key_Password TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(Db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Db?.execSQL("drop table if exists $Database_Table")
        onCreate(Db)

    }
    //add user to database
    fun addUser(users: Users):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Key_Name,users.name)
        contentValues.put(Key_Email,users.email)
        contentValues.put(Key_Phone,users.phone)
        contentValues.put(Key_Password,users.password)
        return db.insert(Database_Table,null,contentValues)

    }
    // Get user details
    fun getUser():ArrayList<Users>{
        val UserArrayList: ArrayList<Users> = ArrayList()
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $Database_Table",null)
        while (cursor.moveToNext()) {
            val name =cursor.getString(1)
            val email =cursor.getString(2)
            val phone =cursor.getString(3)
            val password =cursor.getString(4)
            UserArrayList.add(Users(name,email,phone,password))
        }
        cursor.close()
        db.close()
        return UserArrayList
    }
    // Update user details
    fun updateUser(id:String,name:String, emailid:String,phone: String,pasword:String):Boolean
    {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Key_ID,id)
        contentValues.put(Key_Name,name)
        contentValues.put(Key_Phone,phone)
        contentValues.put(Key_Email,emailid)
        contentValues.put(Key_Password,pasword)
        db.update(Database_Table,contentValues,"$Key_ID=?", arrayOf(id))
        return true
    }
    // Delete user
    fun deleteUser(id:String)  : Int{
        val db = this.writableDatabase
        return  db.delete(Database_Table,"$Key_ID=?", arrayOf(id))

    }
}