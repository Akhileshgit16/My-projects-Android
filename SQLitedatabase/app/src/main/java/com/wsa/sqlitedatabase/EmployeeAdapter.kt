package com.wsa.sqlitedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val employeesArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTv : TextView = itemView.findViewById(R.id.name_tv)
        val emailTv :TextView = itemView.findViewById(R.id.email_tv)
        val phoneTv : TextView =itemView.findViewById(R.id.phone_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeesArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeesArrayList[position]
        holder.nameTv.text = employee.name
        holder.emailTv.text = employee.email
        holder.phoneTv.text = employee.phone
    }
}
