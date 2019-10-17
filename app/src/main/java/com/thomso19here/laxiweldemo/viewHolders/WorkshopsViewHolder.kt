package com.thomso19here.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.dtos.WorkshopsDTO

class WorkshopsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_workshops, parent, false)) {

    private var workshopsImage: ImageView? = null
    private var workshopsName: TextView? = null
    private var workshopCharge: ImageView? = null


    init {
        workshopsImage = itemView.findViewById(R.id.workshopCard)
        workshopsName=itemView.findViewById(R.id.workshopName)
        workshopCharge=itemView.findViewById(R.id.pay_or_free)
    }



    fun bind(mWorkshops: WorkshopsDTO) {
        workshopsImage?.setImageResource(mWorkshops.poster)
        workshopsName?.text=mWorkshops.name
        workshopCharge?.setImageResource(mWorkshops.charges)
    }
}