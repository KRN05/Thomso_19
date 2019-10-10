package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.TeamDTO
import com.example.laxiweldemo.viewHolders.TeamViewHolder

class TeamAdapter(private val teamInfo: ArrayList<TeamDTO>) :
    RecyclerView.Adapter<TeamViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TeamViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val workshops: TeamDTO = teamInfo[position]
        holder.bind(workshops)
    }

    override fun getItemCount(): Int = teamInfo.size

}