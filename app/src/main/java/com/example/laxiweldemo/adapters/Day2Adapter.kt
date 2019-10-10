package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.Day2DTO
import com.example.laxiweldemo.viewHolders.Day2ViewHolder

class Day2Adapter (private val eventsday1: ArrayList<Day2DTO>) :
    RecyclerView.Adapter<Day2ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day2ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day2ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day2ViewHolder, position: Int) {
        val events: Day2DTO = eventsday1[position]
        holder.bind(events)
    }

    override fun getItemCount(): Int = eventsday1.size

}