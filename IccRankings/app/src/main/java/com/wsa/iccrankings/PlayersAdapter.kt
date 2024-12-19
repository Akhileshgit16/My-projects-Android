package com.wsa.iccrankings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PlayersAdapter ( val playersArray: ArrayList<PlayerData>) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvFname : TextView = itemview.findViewById (R.id.frstname_tv)
        val tvLname: TextView = itemview.findViewById (R.id.lastname_tv)
        val tvCountry : TextView = itemview.findViewById (R.id.country_tv)
        val tvBirthdate : TextView = itemview.findViewById (R.id.birthDate_tv)
        val tvRole : TextView = itemview.findViewById (R.id.role_tv)
        val tvStyle: TextView = itemview.findViewById (R.id.style_tv)
        val tvTestrank : TextView = itemview.findViewById (R.id.testranking_tv)
        val tvOdirank : TextView = itemview.findViewById (R.id.odiranking_tv)
        val tvT20rank : TextView = itemview.findViewById (R.id.t20ranking_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.players_item,parent,false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val players = playersArray[position]
        holder.tvFname.text = players.firstName
        holder.tvLname.text = players.lastName
        holder.tvCountry.text = players.country
        holder.tvBirthdate.text = players.birthplace
        holder.tvRole.text = players.role
        holder.tvStyle.text = players.style
        holder.tvTestrank.text = "${holder.itemView.context.getString(R.string.testString)}${players.testRank}"
        holder.tvOdirank.text = "${holder.itemView.context.getString(R.string.odiString)}${players.odiRank}"
        holder.tvT20rank.text = "${holder.itemView.context.getString(R.string.t20String)}${players.t20Rank}"
    }

    override fun getItemCount(): Int {
        return playersArray.size
    }

}
