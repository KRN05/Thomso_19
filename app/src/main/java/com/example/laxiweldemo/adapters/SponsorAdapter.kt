package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.dtos.SponsorsDTO
import com.example.laxiweldemo.dtos.TeamDTO
import com.example.laxiweldemo.viewHolders.SponsorViewHolder
import com.example.laxiweldemo.viewHolders.TeamViewHolder

class SponsorAdapter (private val sponsorInfo: ArrayList<SponsorsDTO>) :
    RecyclerView.Adapter<SponsorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SponsorViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        val sponsors: SponsorsDTO = sponsorInfo[position]
        holder.bind(sponsors)
    }

    override fun getItemCount(): Int = sponsorInfo.size

}