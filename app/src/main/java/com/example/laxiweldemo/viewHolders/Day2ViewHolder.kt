package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.Day1DTO
import com.example.laxiweldemo.dtos.Day2DTO

class Day2ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_day2_list, parent, false)) {

    private var event_time_2: TextView? = null
    private var event_name_2: TextView? = null
    private var event_venue_2: TextView? = null


    init {
        event_name_2= itemView.findViewById(R.id.event_name_2)
        event_time_2=itemView.findViewById(R.id.event_time_2)
        event_venue_2=itemView.findViewById(R.id.event_venue_2)
    }

    fun bind(mEvents: Day2DTO) {
        event_name_2?.text=mEvents.name
        event_time_2?.text= mEvents.time.toString()
        event_venue_2?.text=mEvents.venue
    }
}