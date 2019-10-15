package com.example.laxiweldemo.adapters

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.viewHolders.OngoingViewHolder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList
import android.content.Intent
import kotlinx.android.synthetic.main.events_ongoing_list.view.*


class OngoingAdapter(
    private val eventsday1: ArrayList<EventsDTO>
) :
    RecyclerView.Adapter<OngoingViewHolder>() {

    @RequiresApi(Build.VERSION_CODES.O)
    val current = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    @RequiresApi(Build.VERSION_CODES.O)
    val formatted = current.format(formatter)

    @RequiresApi(Build.VERSION_CODES.O)
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    @RequiresApi(Build.VERSION_CODES.O)
    val timeFormatted = current.format(timeFormatter)


    private val parts: String = formatted.split(" ").toString()
    val mDate = formatted.substring(0, formatted.indexOf(' '))

    val day1 = "14/10/2019"
    val day2 = "19/10/2019"
    val day3 = "20/10/2019"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngoingViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        Log.d("hst", timeFormatted)

        return OngoingViewHolder(inflater, parent)

    }

    /*
    get a size of whole data list
     */
    override fun getItemCount(): Int = eventsday1.size


    override fun onBindViewHolder(holder: OngoingViewHolder, position: Int) {
        Log.d("ongoingadapter", "onBindViewHolder: called.");
        val events: EventsDTO = eventsday1[position]
        holder.bind(events)

        holder.itemView.event_venue_0.setOnClickListener(View.OnClickListener {

        })


        if (mDate.compareTo(day1) == 0) {
            if (events.event_day == "day1") {
                holder.itemView.visibility = View.VISIBLE

                /*
                event onclick listener
                 */
                holder.itemView.setOnClickListener {
                    Log.d("oclick", "onClick: clicked on: ")

                }

            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }

            OngoingAdapter(eventsday1).notifyItemRemoved(position)

        } else if (mDate.compareTo(day2) == 0) {
            if (events.event_day == "day2") {
                holder.itemView.visibility = View.VISIBLE
            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }
            OngoingAdapter(eventsday1).notifyItemRemoved(position)

        } else if (mDate.compareTo(day3) == 0) {
            if (events.event_day == "day3") {
                holder.itemView.visibility = View.VISIBLE
            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }

            OngoingAdapter(eventsday1).notifyItemRemoved(position)
        } else {
            // set ongoing visibility false
        }

    }

    fun intentDetails(intent: Intent, events: EventsDTO, position: Int) {
        intent.putExtra("event_name", events.event_name.get(position))
        intent.putExtra("event_des", events.description.get(position))
        intent.putExtra("event_start", events.start_time.get(position))
        intent.putExtra("event_end", events.end_time.get(position))
        intent.putExtra("event_cod", events.coordinator.get(position))
        intent.putExtra("event_cod_no", events.contact.get(position))
        intent.putExtra("event_location", events.event_location.get(position))
    }

}