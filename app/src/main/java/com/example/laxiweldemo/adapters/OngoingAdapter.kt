package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.OngoingDTO
import com.example.laxiweldemo.viewHolders.OngoingViewHolder

class OngoingAdapter (private val eventsday1: ArrayList<OngoingDTO>) :
    RecyclerView.Adapter<OngoingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngoingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OngoingViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: OngoingViewHolder, position: Int) {
        val events: OngoingDTO = eventsday1[position]
        holder.bind(events)
    }

    override fun getItemCount(): Int = eventsday1.size

}