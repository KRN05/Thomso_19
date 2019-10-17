package com.thomso19here.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.EventsDTO
import com.thomso19here.laxiweldemo.viewHolders.Day3ViewHolder

class Day3Adapter (private val day3Ev: ArrayList<EventsDTO>) :
    RecyclerView.Adapter<Day3ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day3ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day3ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day3ViewHolder, position: Int) {
        val mDay2Ev: EventsDTO = day3Ev[position]
        holder.bind(mDay2Ev)

        if (mDay2Ev.event_day=="day3"){
            holder.itemView.visibility = View.VISIBLE
        }else{
            holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
        }

        Day2Adapter(day3Ev).notifyItemRemoved(position)

    }

    override fun getItemCount(): Int = day3Ev.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}