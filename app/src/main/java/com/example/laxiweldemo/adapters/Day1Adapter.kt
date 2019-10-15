package com.example.laxiweldemo.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.eventsDays.EventOverview
import com.example.laxiweldemo.viewHolders.Day1ViewHolder

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
            Day1Adapter(mDay1Ev).notifyItemRemoved(position)

        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(context, EventOverview::class.java)
//            startActivity(intent)
//        }

    }

    override fun getItemCount(): Int = mDay1Ev.size

    interface MyClickListener {
        fun onItemClick(position: Int, v: View)
    }

}