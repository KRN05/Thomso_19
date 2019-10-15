//package com.example.laxiweldemo.adapters
//
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.laxiweldemo.R
//import com.example.laxiweldemo.dtos.EventsDTO
//import kotlinx.android.synthetic.main.events_ongoing_list.view.*
//
//class OngoingAdapter3(context: Context, private val eventsday1: ArrayList<EventsDTO>) :
//    RecyclerView.Adapter<OngoingAdapter3.MyViewHolder>() {
//
//    var activity: Context = context
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        return MyViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.events_ongoing_list,
//                parent,
//                false
//            ), activity
//        )
//    }
//
//    override fun getItemCount(): Int = eventsday1.size
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val events: EventsDTO = eventsday1[position]
//        holder.bind(events)
//    }
//
//    class MyViewHolder(v: View, context: Context) : RecyclerView.ViewHolder(v),
//        View.OnClickListener {
//        //2
//        private var view: View = v
//        private var lead: EventsDTO? = null
//
//        //3
//        init {
//            v.setOnClickListener(this)
//            v.event_venue_0.setOnClickListener(this)
//        }
//
//        //4
//        override fun onClick(v: View) {
//                val intent = Intent(activity)
//        }
//
//        fun bind(lead: Lead) {
//            this.lead = lead
//            view.leadName.text = lead.cusName
//            view.leadMobileNumber.text = lead.mobileNo.toString()
//            view.loanAmount.text = lead.amount.toString()
//            view.leadId.text = "Lead Id: ${lead.id.toString()}"
//            view.loanType.text = lead.productType
//            view.loanTypeIcon.text = getCharsFromWords(lead.productType)
//        }
//
//        private fun getCharsFromWords(productType: String?): String? {
//            val words = productType!!.split(Regex("\\s+"))
//            val quote: String
//            val sb = StringBuilder()
//            for (word in words) {
//                sb.append(word[0].toString())
//            }
//            quote = sb.toString()
//            return quote
//        }
//
//        companion object {
//            //5
//            private val LEAD_KEY = "LEAD"
//        }
//    }
//
//}