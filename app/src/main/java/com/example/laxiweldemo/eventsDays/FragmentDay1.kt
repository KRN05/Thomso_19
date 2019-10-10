package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.Day1Adapter
import com.example.laxiweldemo.adapters.WorkshopsAdapter
import com.example.laxiweldemo.dtos.Day1DTO
import com.example.laxiweldemo.dtos.WorkshopsDTO
import kotlinx.android.synthetic.main.events_day1.*
import kotlinx.android.synthetic.main.fragment_workshops.view.*
import kotlinx.android.synthetic.main.fragment_workshops.workshops_recycler_view

class FragmentDay1 : Fragment() {


    var day1EventsList = arrayListOf(
        Day1DTO(09.00, "Nukkad Natak" ,"Ug Floor hello boys how are you sab majema"),
        Day1DTO(09.00, "Nukkad Natak and footloose and streetplay" ,"Ug Floor hello boys how are you"),
        Day1DTO(09.00, "Nukkad Natak" ,"Ug Floor"),
        Day1DTO(09.00, "Nukkad Natak" ,"Ug Floor")
    )
    companion object {
        fun newInstance(): FragmentDay1 =
            FragmentDay1()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.events_day1, container, false)

            return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        day1_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            day1_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = Day1Adapter(day1EventsList)
        }
    }
}