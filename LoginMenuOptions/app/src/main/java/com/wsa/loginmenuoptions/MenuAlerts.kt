package com.wsa.loginmenuoptions

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MenuAlerts : DialogFragment() {

    // Interface to send data back to the Activity
    interface MenusDataListener {
        fun onMenusData(
            name: String,
            price: String,
            category: String,
            time: String,
            ratings: String
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())

        // Inflate the dialog layout
        val inflater = LayoutInflater.from(requireContext())
        val view: View = inflater.inflate(R.layout.menualerts,null)

        // Initialize views from the dialog layout
        val foodname_edit: EditText = view.findViewById(R.id.foodname_et)
        val foodprice_edit: EditText = view.findViewById(R.id.foodprice_et)
        val foodcategory_edit: EditText = view.findViewById(R.id.foodcategory_et)
        val foodtime_edit: EditText = view.findViewById(R.id.foodtime_et)
        val foodrating_edit: EditText = view.findViewById(R.id.foodrating_et)
        val addButton: Button = view.findViewById(R.id.add_Btn)

        dialog.setContentView(view)

        // Set the listener to the add button
        addButton.setOnClickListener {
            // Trim input to avoid issues with extra spaces
            val name = foodname_edit.text.toString().trim()
            val price = foodprice_edit.text.toString().trim()
            val category = foodcategory_edit.text.toString().trim()
            val time = foodtime_edit.text.toString().trim()
            val ratings = foodrating_edit.text.toString().trim()

            // Check if all fields are filled
            if (name.isNotEmpty() && price.isNotEmpty() && category.isNotEmpty() && time.isNotEmpty() && ratings.isNotEmpty()) {
                // Safely get the listener and pass data back to the activity
                val listener = activity as? MenusDataListener
                listener?.onMenusData(name, price, category, time, ratings)
                dialog.dismiss() // Close the dialog
            } else {
                // Show a Toast if any field is empty
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        return dialog
    }
}
