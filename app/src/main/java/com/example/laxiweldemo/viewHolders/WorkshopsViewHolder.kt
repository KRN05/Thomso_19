package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.WorkshopsDTO

class WorkshopsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.workshops_list, parent, false)) {

    private var workshopsImage: ImageView? = null
    private var workshopsName: TextView? = null

    init {
        workshopsImage = itemView.findViewById(R.id.workshopCard)
        workshopsName=itemView.findViewById(R.id.workshopName)
    }

    fun bind(mWorkshops: WorkshopsDTO) {
        workshopsImage?.imageAlpha = mWorkshops.poster
        workshopsName?.text=mWorkshops.name
    }
}