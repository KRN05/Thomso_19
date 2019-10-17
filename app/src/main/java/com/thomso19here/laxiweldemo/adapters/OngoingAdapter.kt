package com.thomso19here.laxiweldemo.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.EventsDTO
import com.thomso19here.laxiweldemo.viewHolders.OngoingViewHolder
import kotlin.collections.ArrayList
import java.text.SimpleDateFormat
import java.util.*


class OngoingAdapter(
    private val eventsday1: ArrayList<EventsDTO>
) :
    RecyclerView.Adapter<OngoingViewHolder>() {

   // val mActivity: Context = context

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    private fun checkTimeRange(s1: String, s2: String): Boolean {

        val simpleDateFormat = SimpleDateFormat("HH:mm")

        val date1: Date = simpleDateFormat.parse(s1)

        val date2: Date = simpleDateFormat.parse(s2)

        val d = Date()

        val s3 = simpleDateFormat.format(d)

        val date3 = simpleDateFormat.parse(s3)

        return date3 >= date1 && date3 <= date2
    }

//    fun isNowBetweenDateTime(s: Date, e: Date): Boolean {
//
//        s.after()
//        return date.Interval(s, e).containsNow()
//    }

    val date = getCurrentDateTime()
    val currentDate = date.toString("dd/MM/yyyy")
    val currentTime: String = date.toString("HH:mm")

    val day1 = "18/10/2019"
    val day2 = "19/10/2019"
    val day3 = "20/10/2019"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngoingViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        Log.d("ongoingeve", currentTime)
        return OngoingViewHolder(inflater, parent)
    }

    /*
    get a size of whole data list
     */
    override fun getItemCount(): Int {
        if (eventsday1.size == 0) {
            return 0
        } else {
            return eventsday1.size
        }
    }


    override fun onBindViewHolder(holder: OngoingViewHolder, position: Int) {
        Log.d("ongoingadapter", "onBindViewHolder: called.");
        val events: EventsDTO = eventsday1[position]
        holder.bind(events)


//        val boolday = checkCurrentTimeIsBetweenGivenString(day1 +events.start_time, day1 +events)
//        Log.d("ongoingeveha", boolday.toString())

        if (currentDate.compareTo(day1) == 0) {

            if (events.event_day == "day1" && checkTimeRange(events.start_time, events.end_time)) {
                holder.itemView.visibility = View.VISIBLE

            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }


        } else if (currentDate.compareTo(day2) == 0) {
            if (events.event_day == "day2" && checkTimeRange(events.start_time, events.end_time)) {
                holder.itemView.visibility = View.VISIBLE
            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }
        } else if (currentDate.compareTo(day3) == 0) {
            if (events.event_day == "day3" && checkTimeRange(events.start_time, events.end_time)) {
                holder.itemView.visibility = View.VISIBLE
            } else {
                holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            }
        } else {
            holder.itemView.layoutParams = LinearLayout.LayoutParams(0, 0)
            // set ongoing visibility false
            //     holder.itemView.ongoing_recycler_view.visibility = View.GONE
            //  holder.itemView.ongoing_visibility.text="NO ONGOING EVENT"
           // val intent = Intent(mActivity, FragmentOnGoing::class.java)
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
