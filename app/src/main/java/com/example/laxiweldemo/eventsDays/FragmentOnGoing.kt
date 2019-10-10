package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.OngoingAdapter
import com.example.laxiweldemo.dtos.OngoingDTO
import kotlinx.android.synthetic.main.events_day1.*
import kotlinx.android.synthetic.main.events_ongoing.*

class FragmentOnGoing : Fragment() {



    var ongoingEventsList = arrayListOf(
        OngoingDTO(09.00, "Nukkad Natak" ,"Ug Floor hello boys how are you sab majema"),
        OngoingDTO(09.00, "Nukkad Natak and footloose and streetplay" ,"Ug Floor hello boys how are you"),
        OngoingDTO(09.00, "Nukkad Natak" ,"Ug Floor"),
        OngoingDTO(09.00, "Nukkad Natak" ,"Ug Floor")
    )

    companion object {
        fun newInstance(): FragmentOnGoing =
            FragmentOnGoing()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.events_ongoing, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ongoing_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            ongoing_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = OngoingAdapter(ongoingEventsList)
        }
    }
}