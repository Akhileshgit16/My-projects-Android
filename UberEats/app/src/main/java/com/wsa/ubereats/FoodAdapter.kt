package com.wsa.ubereats

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(val uberArrayList: ArrayList<Foodclas>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    class ViewHolder(val itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val foodImage: ImageView =itemview.findViewById(R.id.foodimageView)
        val foodName: TextView =itemview.findViewById(R.id.foodtextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.items_food,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        val foods = uberArrayList[position]
         holder.foodImage.setImageResource(foods.bomma)

        // Use the getFormattedName() method to set the text with the required color formatting
        holder.foodName.text = foods.getFormattedName()

        // use the holder.foodName.text=foods.peru

        holder.foodImage.setOnClickListener(View.OnClickListener{
            val intent =Intent(it.context,DetailsActivity::class.java)
            intent.putExtra("foodImage",foods.bomma)
            intent.putExtra("foodName",foods.peru)
            it.context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return uberArrayList.size
    }
}
