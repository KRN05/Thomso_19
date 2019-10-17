package com.thomso19here.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.adapters.HomeAdapterMajorA
import com.thomso19here.laxiweldemo.adapters.HomeAdapterPronites
import com.thomso19here.laxiweldemo.dtos.MajorAtrractionDTO
import com.thomso19here.laxiweldemo.dtos.PronitesDTO
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment: Fragment(){



    var pronitesList = arrayListOf(
        PronitesDTO(R.drawable.salim_3),
        PronitesDTO(R.drawable.jubin_yes_1)
        //PronitesDTO(R.drawable.vinai_2)
    )

    var majorAttractionList = arrayListOf(
        MajorAtrractionDTO(R.drawable.ad_f_1),
        MajorAtrractionDTO(R.drawable.sardar_1),
        MajorAtrractionDTO(R.drawable.m_s_final)
    )


    companion object {
        fun newInstance(): HomeFragment =
            HomeFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        pronites_recyclerview.isNestedScrollingEnabled
//        majorAttractions_recyclerview.isNestedScrollingEnabled
        /*
        pronites recyclerview
         */

        pronites_recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        

            // set the custom adapter to the RecyclerView
        pronites_recyclerview.adapter = HomeAdapterPronites(pronitesList)


        /*
        major attraction recyclerview
         */
        majorAttractions_recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // set the custom adapter to the RecyclerView
        majorAttractions_recyclerview.adapter = HomeAdapterMajorA(majorAttractionList)


    }
}
