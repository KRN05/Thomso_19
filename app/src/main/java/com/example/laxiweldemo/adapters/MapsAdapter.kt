package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.MapLocationsDTO
import com.example.laxiweldemo.viewHolders.MapsViewHolder


class MapsAdapter(private val mapLocations: ArrayList<MapLocationsDTO>) :
    RecyclerView.Adapter<MapsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MapsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        val locations: MapLocationsDTO = mapLocations[position]
        holder.bind(locations)
    }

    override fun getItemCount(): Int = mapLocations.size

}