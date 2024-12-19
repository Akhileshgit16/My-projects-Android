package com.wsa.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    //initialization
    lateinit var nameTv: TextView
    lateinit var phoneTv: TextView
    lateinit var mailTv: TextView
    lateinit var designTv: TextView
    lateinit var refresh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        //loading
        nameTv =findViewById(R.id.name_tv)
        phoneTv= findViewById(R.id.number_tv)
        mailTv = findViewById(R.id.mail_tv)
        designTv = findViewById(R.id.design_tv)
        refresh = findViewById(R.id.refresh_btn)
        //listners
        val nam = intent.getStringExtra("name").toString()
        nameTv.text=nam
        val mobile = intent.getStringExtra("phonenum").toString()
        phoneTv.text= mobile
        val mailId = intent.getStringExtra("email").toString()
        mailTv.text = mailId
        val design = intent.getStringExtra("desgination").toString()
        designTv.text = design

        refresh.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

}