package com.wsa.jsondemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val employeeAray: ArrayList<Employees>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val empName: TextView = itemView.findViewById(R.id.name_tv)
        val empMail: TextView = itemView.findViewById(R.id.email_tv)
        val empPhone: TextView = itemView.findViewById(R.id.phone_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflate layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emp_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeAray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //view holder
        val emp = employeeAray[position]
        holder.empName.text = emp.name
        holder.empMail.text = emp.email
        holder.empPhone.text = emp.phone
    }
}
