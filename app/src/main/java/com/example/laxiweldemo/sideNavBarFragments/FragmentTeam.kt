package com.example.laxiweldemo.sideNavBarFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.TeamAdapter
import com.example.laxiweldemo.adapters.WorkshopsAdapter
import com.example.laxiweldemo.dtos.TeamDTO
import kotlinx.android.synthetic.main.fragment_team.*
import kotlinx.android.synthetic.main.fragment_workshops.*
import kotlinx.android.synthetic.main.fragment_workshops.view.*
import kotlinx.android.synthetic.main.fragment_workshops.workshops_recycler_view


class FragmentTeam : Fragment() {

    val teamList = arrayListOf(
        TeamDTO(R.drawable.ic_launcher, "Karan Bobade", "Developer","karanb.thomso@gmail.com", "7218689420")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_team, container, false)

    companion object {
        fun newInstance(): FragmentTeam =
            FragmentTeam()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        team_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            team_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = TeamAdapter(teamList)
        }
    }
}