package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.CarnivalAdapter
import com.example.laxiweldemo.adapters.TeamAdapter
import kotlinx.android.synthetic.main.fragment_carnival.*
import kotlinx.android.synthetic.main.fragment_team.*

class CarnivalFragment : Fragment(){

    companion object {
        fun newInstance(): CarnivalFragment =
            CarnivalFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_carnival, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carnival_recycler_view.apply {

            layoutManager=GridLayoutManager(activity, 2)

            carnival_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = CarnivalAdapter(teamMembers.TeamDetails)
        }
    }
}