package com.example.laxiweldemo.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.eventsDays.OnItemClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.events_ongoing_list.*

class OngoingAdapter2( private val
    eventsday1: ArrayList<EventsDTO>, listener: OnItemClickListener<EventsDTO>?
) : RecyclerView.Adapter<OngoingAdapter2.OngoingViewHolder2>() {


    var EventsDTO = eventsday1
    var onItemClickListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngoingViewHolder2 {
        return OngoingViewHolder2(
            LayoutInflater.from(parent.context).inflate(
                R.layout.events_ongoing_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = eventsday1.size

    override fun onBindViewHolder(holder: OngoingViewHolder2, position: Int) {
        val events: EventsDTO = eventsday1[position]
        holder.bind(events)
    }

    inner class OngoingViewHolder2(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        init {
            ButterKnife.bind(this, itemView)
        }

        val mEvents: EventsDTO? = null

        fun bind(mEvents: EventsDTO? ) {
            event_name_0?.text = mEvents?.event_name
            event_time_0?.text = mEvents?.start_time.toString()
            event_venue_0?.text = mEvents?.event_location
        }

        @OnClick(R.id.ongoing_list_layout)
        fun onClickItem() {
            if (null != itemView.tag) {
                val emiItem = itemView.tag as EventsDTO

                //Event with parameter
//                val intent = Intent(mContext, EventOverview::class.java)
                val paramClick = Bundle()
                paramClick.putString("CLICK ONGOIN", "HAAN BHAN CLICKED" + (EventsDTO.indexOf(emiItem) + 1))
                onItemClickListener?.onItemClick(emiItem)

            }
        }

        fun intentDetails(intent: Intent, events: EventsDTO) {
            intent.putExtra("event_name", events.event_name)
            intent.putExtra("event_des", events.description)
            intent.putExtra("event_start", events.start_time)
            intent.putExtra("event_end", events.end_time)
            intent.putExtra("event_cod", events.coordinator)
            intent.putExtra("event_cod_no", events.contact)
            intent.putExtra("event_location", events.event_location)
        }
    }
}