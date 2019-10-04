package com.example.laxiweldemo.actionBarGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R

class Faqs : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_carnival, container, false)

    companion object {
        fun newInstance(): Faqs =
            Faqs()
    }
}