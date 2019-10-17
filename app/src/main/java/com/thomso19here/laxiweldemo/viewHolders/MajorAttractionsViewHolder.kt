package com.thomso19here.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.dtos.MajorAtrractionDTO

class MajorAttractionsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_major_attraction, parent, false)) {

    private var majorAImage: ImageView? = null

    init {
        majorAImage = itemView.findViewById(R.id.majorAttractions)
    }

    fun bind(mMajorA: MajorAtrractionDTO) {
        majorAImage?.setImageResource(mMajorA.poster)
    }
}