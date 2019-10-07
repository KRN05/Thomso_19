package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.MajorAtrractionDTO
import com.example.laxiweldemo.dtos.PronitesDTO
import com.example.laxiweldemo.viewHolders.MajorAttractionsViewHolder
import com.example.laxiweldemo.viewHolders.PronitesViewHolder

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