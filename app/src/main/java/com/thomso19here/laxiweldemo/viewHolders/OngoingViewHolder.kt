package com.thomso19here.laxiweldemo.viewHolders

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.dtos.EventsDTO
import com.thomso19here.laxiweldemo.eventsDays.EventOverview


class OngoingViewHolder(
    inflater: LayoutInflater, parent: ViewGroup
) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_ongoing_list, parent, false)) {


    private var event_time_0: TextView? = null
    private var event_name_0: TextView? = null
    private var event_venue_0: TextView? = null
    private var view: View? = null

    init {
        event_name_0 = itemView.findViewById(R.id.event_name_0)
        event_time_0 = itemView.findViewById(R.id.event_time_0)
        event_venue_0 = itemView.findViewById(R.id.event_venue_0)

    }

    fun bind(mEvents: EventsDTO) {
        event_name_0?.text = mEvents.event_name
        event_time_0?.text = mEvents.start_time.toString()
        event_venue_0?.text = mEvents.event_location

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