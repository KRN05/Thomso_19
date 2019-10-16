package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.FaqDTO
import com.example.laxiweldemo.viewHolders.FaqsViewHolder

class FaqAdapter (private val faq: ArrayList<FaqDTO>) :
    RecyclerView.Adapter<FaqsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FaqsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FaqsViewHolder, position: Int) {
        val mFaq: FaqDTO = faq[position]
        holder.bind(mFaq)
    }

    override fun getItemCount(): Int = 13

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

