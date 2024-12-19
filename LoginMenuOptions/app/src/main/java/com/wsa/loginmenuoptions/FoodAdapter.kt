package com.wsa.loginmenuoptions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val menuArrayLst: ArrayList<menuData>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val foodName = item.findViewById<TextView>(R.id.foodname_tv)
        val foodPrice = item.findViewById<TextView>(R.id.foodprice_tv)
        val foodCategory = item.findViewById<TextView>(R.id.foodcategory_tv)
        val foodTime = item.findViewById<TextView>(R.id.foodtime_tv)
        val foodRating= item.findViewById<TextView>(R.id.foodrating_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity_foods,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int { return menuArrayLst.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuitem = menuArrayLst[position]
        holder.foodName.text = "Food Name is : ${menuitem.foodname}"
        holder.foodPrice.text = "Food price is : ${menuitem.foodprice}"
        holder.foodCategory.text = "Food Category is : ${menuitem.foodCategory}"
        holder.foodTime.text ="Food preparation time is : ${menuitem.foodTime}"
        holder.foodRating.text ="Food Rating is : ${menuitem.foodRating}"

    }

}
