package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.MapLocationsDTO

class MapsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_map_locations, parent, false)) {

    private var mMapLocation: TextView? = null

    init {
        mMapLocation=itemView.findViewById(R.id.mapsButton)
    }

    fun bind(mapLocation: MapLocationsDTO){
        mMapLocation?.text=mapLocation.mLocation
    }
}