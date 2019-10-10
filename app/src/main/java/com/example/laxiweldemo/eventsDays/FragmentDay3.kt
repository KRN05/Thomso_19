package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.Day1Adapter
import com.example.laxiweldemo.adapters.Day3Adapter
import com.example.laxiweldemo.dtos.Day3DTO
import kotlinx.android.synthetic.main.events_day1.*
import kotlinx.android.synthetic.main.events_day3.*


class FragmentDay3 : Fragment() {

    var day3EventsList = arrayListOf(
        Day3DTO(09.00, "Nukkad Natak" ,"Ug Floor hello boys how are you sab majema"),
        Day3DTO(09.00, "Nukkad Natak and footloose and streetplay" ,"Ug Floor hello boys how are you"),
        Day3DTO(09.00, "Nukkad Natak" ,"Ug Floor"),
        Day3DTO(09.00, "Nukkad Natak" ,"Ug Floor")
    )
    companion object {
        fun newInstance(): FragmentDay3 =
            FragmentDay3()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.events_day3, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        day3_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            day3_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = Day3Adapter(day3EventsList)
        }
    }
}