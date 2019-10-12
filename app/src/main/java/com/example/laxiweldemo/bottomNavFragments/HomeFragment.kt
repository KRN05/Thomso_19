package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.HomeAdapterMajorA
import com.example.laxiweldemo.adapters.HomeAdapterPronites
import com.example.laxiweldemo.dtos.MajorAtrractionDTO
import com.example.laxiweldemo.dtos.PronitesDTO
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment: Fragment(){



    var pronitesList = arrayListOf(
        PronitesDTO(R.drawable.tiger),
        PronitesDTO(R.drawable.tiger),
        PronitesDTO(R.drawable.tiger)
    )

    var majorAttractionList = arrayListOf(
        MajorAtrractionDTO(R.drawable.major_att),
        MajorAtrractionDTO(R.drawable.major_att),
        MajorAtrractionDTO(R.drawable.major_att)
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
