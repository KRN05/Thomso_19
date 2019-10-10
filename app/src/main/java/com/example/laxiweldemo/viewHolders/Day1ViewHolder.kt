package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.Day1DTO

class Day1ViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_day1_list, parent, false)) {

    private var event_time_1: TextView? = null
    private var event_name_1: TextView? = null
    private var event_venue_1: TextView? = null


    init {
          event_name_1= itemView.findViewById(R.id.event_name_1)
        event_time_1=itemView.findViewById(R.id.event_time_1)
        event_venue_1=itemView.findViewById(R.id.event_venue_1)
    }

    fun bind(mEvents: Day1DTO) {
        event_name_1?.text=mEvents.name
        event_time_1?.text= mEvents.time.toString()
        event_venue_1?.text=mEvents.venue
    }
}