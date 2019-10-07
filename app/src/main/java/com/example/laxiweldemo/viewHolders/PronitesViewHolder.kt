package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.PronitesDTO

class PronitesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_pronites, parent, false)) {

    private var pronitesImage: ImageView? = null

    init {
        pronitesImage = itemView.findViewById(R.id.pronites_card)
    }

    fun bind(mPronites: PronitesDTO) {
        pronitesImage?.imageAlpha = mPronites.poster
    }
}