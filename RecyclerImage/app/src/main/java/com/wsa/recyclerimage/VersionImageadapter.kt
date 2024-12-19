package com.wsa.recyclerimage

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class VersionImageadapter(val versionsimageArray: Array<Int>) : RecyclerView.Adapter<VersionImageadapter.ViewHolder>() {
    class ViewHolder(item:View):RecyclerView.ViewHolder (item) {
        val verimageview: ImageView=item.findViewById(R.id.VersionimageView)
        val vernameview: ImageView=item.findViewById(R.id.)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.verimageview.setBackgroundResource(versionsimageArray[position])
        holder.verimageview.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context,DetailedActivity::class.java)
            intent.putExtra("itemclick",versionsimageArray[position])
            it.context.startActivity(intent)
        })
    }
    override fun getItemCount(): Int {
        return versionsimageArray.size
    }
}
