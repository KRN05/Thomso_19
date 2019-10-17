package com.thomso19here.laxiweldemo.sideNavBarFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.thomso19here.laxiweldemo.R

class FragmentFoodnBeverages : Fragment(){

    companion object {
        fun newInstance(): FragmentFoodnBeverages =
            FragmentFoodnBeverages()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view= inflater.inflate(R.layout.fragment_food_n_beverages, container, false)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        toolbar.title="FOOD N BEVERAGES"

        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        //for crate home button
        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return view
    }

}