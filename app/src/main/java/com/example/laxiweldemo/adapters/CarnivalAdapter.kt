package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.CarnivalNameDTO
import com.example.laxiweldemo.viewHolders.CarnivalVH

class CarnivalAdapter (private val workshops: ArrayList<CarnivalNameDTO>) :
    RecyclerView.Adapter<CarnivalVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarnivalVH {
        val inflater = LayoutInflater.from(parent.context)
        return CarnivalVH(inflater, parent)
    }

    override fun onBindViewHolder(holder: CarnivalVH, position: Int) {
        val workshops: CarnivalNameDTO = workshops[position]
        holder.bind(workshops)
    }

    override fun getItemCount(): Int = workshops.size

}