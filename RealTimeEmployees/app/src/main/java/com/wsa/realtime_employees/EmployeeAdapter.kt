package com.wsa.realtime_employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeArrayLists: ArrayList<EmployeeData>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById (R.id.name_tv)
        val tvEmail: TextView = itemView.findViewById (R.id.email_tv)
        val tvPhone : TextView = itemView.findViewById (R.id.phone_tv)
        val tvDesignation : TextView = itemView.findViewById (R.id.design_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.employe_row, parent, false)
        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return employeArrayLists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //view holder
        val emp = employeArrayLists[position]
        holder.tvName.text = emp.name
        holder.tvEmail.text = emp.email
        holder.tvPhone.text = emp.phone
        holder.tvDesignation.text = emp.designation
    }

}
