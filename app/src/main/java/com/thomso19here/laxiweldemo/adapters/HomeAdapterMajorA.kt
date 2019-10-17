package com.thomso19here.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.MajorAtrractionDTO
import com.thomso19here.laxiweldemo.viewHolders.MajorAttractionsViewHolder

class HomeAdapterMajorA  (private val kpronites: ArrayList<MajorAtrractionDTO>) :
    RecyclerView.Adapter<MajorAttractionsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorAttractionsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MajorAttractionsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MajorAttractionsViewHolder, position: Int) {
        val pronites: MajorAtrractionDTO = kpronites[position]
        holder.bind(pronites)
    }

    override fun getItemCount(): Int = kpronites.size

}