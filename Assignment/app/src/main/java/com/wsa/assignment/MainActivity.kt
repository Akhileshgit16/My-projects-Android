package com.wsa.assignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var Yourname: EditText
    lateinit var Phone: EditText
    lateinit var Emailid: EditText
    lateinit var Designation: EditText
    lateinit var submit_bt: Button
    lateinit var YournameTv: TextView
    lateinit var PhoneTv: TextView
    lateinit var mailTv: TextView
    lateinit var designTv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading values
        Yourname = findViewById(R.id.name_txt)
        Phone = findViewById(R.id.phone_txt)
        Emailid = findViewById(R.id.email_txt)
        Designation = findViewById(R.id.Designation_txt)
        YournameTv =findViewById(R.id.nameView)
        PhoneTv= findViewById(R.id.phoneView)
        mailTv = findViewById(R.id.emailView)
        designTv = findViewById(R.id.designView)
        submit_bt = findViewById(R.id.submit_btn)
        submit_bt.setOnClickListener(View.OnClickListener {
            val name:String = Yourname.text.toString()
            YournameTv.text=name
            Yourname.setText("")

            val phoneNumber:String = Phone.text.toString()
            PhoneTv.text=phoneNumber
            Phone.setText("")

            val email:String = Emailid.text.toString()
            mailTv.text= email
            Emailid.setText("")

            val designation :String = Designation.text.toString()
            designTv.text=designation
            Designation.setText("")

        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}