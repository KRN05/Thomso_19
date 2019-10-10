package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.Day3DTO

class Day3ViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_day3_list, parent, false)) {

    private var event_time_3: TextView? = null
    private var event_name_3: TextView? = null
    private var event_venue_3: TextView? = null


    init {
        event_name_3= itemView.findViewById(R.id.event_name_3)
        event_time_3=itemView.findViewById(R.id.event_time_3)
        event_venue_3=itemView.findViewById(R.id.event_venue_3)
    }

    fun bind(mEvents: Day3DTO) {
        event_name_3?.text=mEvents.name
        event_time_3?.text= mEvents.time.toString()
        event_venue_3?.text=mEvents.venue
    }
}