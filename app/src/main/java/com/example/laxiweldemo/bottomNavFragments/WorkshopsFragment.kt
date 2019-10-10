package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.WorkshopsAdapter
import com.example.laxiweldemo.dtos.WorkshopsDTO
import kotlinx.android.synthetic.main.fragment_workshops.*

import kotlinx.android.synthetic.main.fragment_workshops.view.workshops_recycler_view


class WorkshopsFragment : Fragment() {

    var workshopsList = arrayListOf(
        WorkshopsDTO(R.drawable.ic_ai, "ARTIFICIAL " +
                "INTELLIGENCE", R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_iot, "INTERNET OF " +
                "THINGS",R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_origami, "ORIGAMI", R.drawable.ic_free_now),
        WorkshopsDTO(R.drawable.ic_fitness, "FITNESS", R.drawable.ic_free_now),
        WorkshopsDTO(R.drawable.ic_pg, "PHOTOGRAPHY", R.drawable.ic_free_now)
    )

    companion object {
        fun newInstance(): WorkshopsFragment =
            WorkshopsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_workshops, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workshops_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            workshops_recycler_view.
            // set the custom adapter to the RecyclerView
            adapter = WorkshopsAdapter(workshopsList)
        }
    }
}