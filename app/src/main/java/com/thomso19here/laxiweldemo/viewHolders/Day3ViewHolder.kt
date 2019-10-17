package com.thomso19here.laxiweldemo.viewHolders

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.dtos.EventsDTO
import com.thomso19here.laxiweldemo.eventsDays.EventOverview

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

    fun bind(mEvents: EventsDTO) {
        event_name_3?.text=mEvents.event_name
        event_time_3?.text= mEvents.start_time.toString()
        event_venue_3?.text=mEvents.event_location

        itemView.setOnClickListener {
            Log.d("ongoingclick", "clicked on don")

            val intent = Intent(itemView.context, EventOverview::class.java)
            intent.putExtra("event_name", mEvents.event_name)
            intent.putExtra("event_des", mEvents.description)
            intent.putExtra("event_start", mEvents.start_time)
            intent.putExtra("event_end", mEvents.end_time)
            intent.putExtra("event_cod", mEvents.coordinator)
            intent.putExtra("event_cod_no", mEvents.contact)
            intent.putExtra("event_location", mEvents.event_location)
            intent.putExtra("event_lat", mEvents.lat)
            itemView.context.startActivity(intent)
        }
    }
}