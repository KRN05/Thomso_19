package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R

class Day2 : Fragment() {

    companion object {
        fun newInstance(): Day2 =
            Day2()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.day2, container, false)


        return view
    }
}