package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.FaqDTO

class FaqsViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_faq, parent, false)) {

    private var faqTitle: TextView? = null
    private var faqDescription: TextView? = null


    init {
        faqTitle = itemView.findViewById(R.id.faq_title)
        faqDescription=itemView.findViewById(R.id.faq_description)
    }

    fun bind(mFaq: FaqDTO) {
        faqTitle?.text = mFaq.title
        faqDescription?.text = mFaq.description

    }
}