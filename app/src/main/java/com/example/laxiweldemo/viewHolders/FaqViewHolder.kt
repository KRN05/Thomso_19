package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.FaqDTO

class FaqViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_faq, parent, false)) {

    private var mFaqs: TextView? = null
    private var mFaqsDescription: TextView? = null


    init {
        mFaqs=itemView.findViewById<TextView>(R.id.faq_title)
        mFaqsDescription?.findViewById<TextView>(R.id.faq_description)
    }

    fun bind(faqs: FaqDTO){
        mFaqs?.text=faqs.title
        mFaqsDescription?.text=faqs.description

    }
}