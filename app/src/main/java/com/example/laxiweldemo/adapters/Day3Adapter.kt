package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.Day3DTO
import com.example.laxiweldemo.viewHolders.Day3ViewHolder

class Day3Adapter (private val eventsday1: ArrayList<Day3DTO>) :
    RecyclerView.Adapter<Day3ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day3ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day3ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day3ViewHolder, position: Int) {
        val events: Day3DTO = eventsday1[position]
        holder.bind(events)
    }

    override fun getItemCount(): Int = eventsday1.size

}