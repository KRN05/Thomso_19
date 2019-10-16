package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.viewHolders.Day2ViewHolder
import android.widget.LinearLayout



class Day2Adapter (private val mDay2Ev: ArrayList<EventsDTO>) :
    RecyclerView.Adapter<Day2ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day2ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day2ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day2ViewHolder, position: Int) {
        val day2Ev: EventsDTO = mDay2Ev[position]
        holder.bind(day2Ev)

        if (day2Ev.event_day=="day2"){
            holder.itemView.visibility = View.VISIBLE
        }else{
            holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
        }
    }

    override fun getItemCount(): Int = mDay2Ev.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}