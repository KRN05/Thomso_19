package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.PronitesDTO
import com.example.laxiweldemo.viewHolders.PronitesViewHolder

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