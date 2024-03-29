package com.thomso19here.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.EventsDTO
import com.thomso19here.laxiweldemo.viewHolders.Day1ViewHolder

class Day1Adapter (private val mDay1Ev: ArrayList<EventsDTO>) :
    RecyclerView.Adapter<Day1ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Day1ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return Day1ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: Day1ViewHolder, position: Int) {
        val day1Ev: EventsDTO = mDay1Ev[position]
        holder.bind(day1Ev)

        holder.itemView.visibility = View.GONE;

        if (day1Ev.event_day=="day1"){
            holder.itemView.visibility = View.VISIBLE;
        }
        else{
            holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
//            Day1Adapter(mDay1Ev).notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int = mDay1Ev.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}