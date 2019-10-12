package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.CarnivalNameDTO

class CarnivalVH (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_carnival, parent, false)) {

   // private var carnivalTitle: TextView? = null
    private var carnivalName: TextView? = null


    init {
       // carnivalTitle = itemView.findViewById(R.id.carnival_title)
        carnivalName = itemView.findViewById(R.id.carnival_name)


    }

    fun bind(mCarnival: CarnivalNameDTO) {
     //   carnivalTitle?.text =mCarnival.title
        carnivalName?.text=mCarnival.name

    }
}