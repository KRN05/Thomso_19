package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.SponsorsDTO

class SponsorViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_sponsors, parent, false)) {

    private var sponsorsImage: ImageView? = null

    init {
        sponsorsImage = itemView.findViewById(R.id.sponsor_avatar)
    }

    fun bind(mSponsors: SponsorsDTO) {
        sponsorsImage?.setImageResource(mSponsors.sponsorsAvatar)
    }
}