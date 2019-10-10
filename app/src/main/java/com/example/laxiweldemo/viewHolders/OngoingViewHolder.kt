package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.Day1DTO
import com.example.laxiweldemo.dtos.OngoingDTO

class OngoingViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_ongoing_list, parent, false)) {

    private var event_time_0: TextView? = null
    private var event_name_0: TextView? = null
    private var event_venue_0: TextView? = null


    init {
        event_name_0= itemView.findViewById(R.id.event_name_0)
        event_time_0=itemView.findViewById(R.id.event_time_0)
        event_venue_0=itemView.findViewById(R.id.event_venue_0)
    }

    fun bind(mEvents: OngoingDTO) {
        event_name_0?.text=mEvents.name
        event_time_0?.text= mEvents.time.toString()
        event_venue_0?.text=mEvents.venue
    }
}