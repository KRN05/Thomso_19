package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R

class OnGoing : Fragment() {

    companion object {
        fun newInstance(): OnGoing =
            OnGoing()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.ongoing, container, false)


        return view
    }
}