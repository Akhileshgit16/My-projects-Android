package com.wsa.dec06activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuItemsActivity : AppCompatActivity() {

    private lateinit var productNameEdit: EditText
    private lateinit var productPriceEdit: EditText
    private lateinit var addBtn: Button
    private lateinit var cameraBtn: Button
    private var imageUri: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_items)

        productNameEdit = findViewById(R.id.productNameEditText)
        productPriceEdit = findViewById(R.id.productPriceEditText)
        cameraBtn = findViewById(R.id.gallery_btn)
        addBtn = findViewById(R.id.addButton)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}