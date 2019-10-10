package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.Day1DTO
import com.example.laxiweldemo.dtos.WorkshopsDTO
import com.example.laxiweldemo.viewHolders.Day1ViewHolder
import com.example.laxiweldemo.viewHolders.WorkshopsViewHolder

class Day1Adapter (private val eventsday1: ArrayList<Day1DTO>) :
    RecyclerView.Adapter<Day1ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day1ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day1ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day1ViewHolder, position: Int) {
        val events: Day1DTO = eventsday1[position]
        holder.bind(events)
    }

    override fun getItemCount(): Int = eventsday1.size

}