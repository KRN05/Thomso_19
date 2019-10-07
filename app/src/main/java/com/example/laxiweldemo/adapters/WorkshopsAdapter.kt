package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.WorkshopsDTO
import com.example.laxiweldemo.viewHolders.MapsViewHolder
import com.example.laxiweldemo.viewHolders.WorkshopsViewHolder

class WorkshopsAdapter(private val workshops: ArrayList<WorkshopsDTO>) :
    RecyclerView.Adapter<WorkshopsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WorkshopsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WorkshopsViewHolder, position: Int) {
        val workshops: WorkshopsDTO = workshops[position]
        holder.bind(workshops)
    }

    override fun getItemCount(): Int = workshops.size

}