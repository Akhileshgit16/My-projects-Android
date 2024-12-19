package com.wsa.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //initializing
    lateinit var yourName: EditText
    lateinit var phone: EditText
    lateinit var emailid: EditText
    lateinit var design: EditText
    lateinit var regist:TextView
    lateinit var enterdetail: TextView
    lateinit var submit_bt: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load values
        yourName = findViewById(R.id.name_et)
        phone = findViewById(R.id.mob_et)
        emailid = findViewById(R.id.email_et)
        design = findViewById(R.id.design_et)
        regist = findViewById(R.id.register_tv)
        enterdetail = findViewById(R.id.enterdetail_tv)
        submit_bt = findViewById(R.id.submit_et)
        submit_bt.setOnClickListener(this,)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("name",yourName.text.toString())
        intent.putExtra("phonenum",phone.text.toString())
        intent.putExtra("email",emailid.text.toString())
        intent.putExtra("desgination",design.text.toString())
        intent.putExtra("Register",regist.text.toString())
        intent.putExtra("enterdetail",enterdetail.text.toString())
        startActivity(intent)
    }
}