package com.thomso19here.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.PronitesDTO
import com.thomso19here.laxiweldemo.viewHolders.PronitesViewHolder

class HomeAdapterPronites (private val kpronites: ArrayList<PronitesDTO>) :
    RecyclerView.Adapter<PronitesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PronitesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PronitesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PronitesViewHolder, position: Int) {
        val pronites: PronitesDTO = kpronites[position]
        holder.bind(pronites)
    }

    override fun getItemCount(): Int = kpronites.size

}