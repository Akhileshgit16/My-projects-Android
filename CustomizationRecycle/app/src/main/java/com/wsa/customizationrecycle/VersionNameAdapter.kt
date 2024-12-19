package com.wsa.customizationrecycle

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VersionNameAdapter(val  ArrayList: ArrayList<Version>) : RecyclerView.Adapter<VersionNameAdapter.ViewHolder>() {
    class ViewHolder(val itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val foodImage: ImageView =itemview.findViewById(R.id.version_img)
        val foodName: TextView =itemview.findViewById(R.id.version_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionNameAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionNameAdapter.ViewHolder, position: Int) {
        val foods = ArrayList[position]
        holder.foodImage.setImageResource(foods.vImag)
        holder.foodName.text=foods.vName

    }

    override fun getItemCount(): Int {
        return ArrayList.size
    }
}
