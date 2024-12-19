package com.wsa.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionsAdapter(val versionArray: Array<String>) : RecyclerView.Adapter<VersionsAdapter.ViewHolder>() {
    class ViewHolder(items: View):RecyclerView.ViewHolder(items)
    {
        val  versionName:TextView = items.findViewById(R.id.versionname_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionsAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionsAdapter.ViewHolder, position: Int) {
        holder.versionName.text = versionArray[position]
    }

    override fun getItemCount(): Int {
        return versionArray.size
    }

}



