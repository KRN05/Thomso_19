package com.example.laxiweldemo.viewHolders

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.eventsDays.EventOverview


class Day1ViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.events_day1_list, parent, false))  {

    private var myClickListener : View.OnClickListener?=null


    private var event_time_1: TextView? = null
    private var event_name_1: TextView? = null
    private var event_venue_1: TextView? = null


    init {
          event_name_1= itemView.findViewById(R.id.event_name_1)
        event_time_1=itemView.findViewById(R.id.event_time_1)
        event_venue_1=itemView.findViewById(R.id.event_venue_1)
    }

    fun bind(mEvents: EventsDTO) {
        event_name_1?.text=mEvents.event_name
        event_time_1?.text= mEvents.start_time.toString()
        event_venue_1?.text=mEvents.event_location

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
            itemView.context.startActivity(intent)
        }
    }

//    fun onClick(v: View) {
//        myClickListener.onItemClick(layoutPosition, v)
//
//    }

    fun setOnItemClickListener(myClickListener: View.OnClickListener) {
        this.myClickListener = myClickListener

    }
}