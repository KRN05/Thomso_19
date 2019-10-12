package com.example.laxiweldemo.sideNavBarFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.SponsorAdapter
import com.example.laxiweldemo.dtos.SponsorsDTO
import kotlinx.android.synthetic.main.fragment_sponsors.*

class FragmentSponsors : Fragment() {

    val sponorsList = arrayListOf(
        SponsorsDTO(R.drawable.ic_fitness)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view= inflater.inflate(R.layout.fragment_sponsors, container, false)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        toolbar.title="SPONSORS"

        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        //for crate home button
        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return view

    }

    companion object {
        fun newInstance(): FragmentSponsors =
            FragmentSponsors()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sponsors_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 3)
            sponsors_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = SponsorAdapter(sponorsList)
        }
    }
}