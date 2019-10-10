package com.example.laxiweldemo.actionBarGroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laxiweldemo.DashboardActivity
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.MapsAdapter
import com.example.laxiweldemo.dtos.MapLocationsDTO
import kotlinx.android.synthetic.main.fragment_maps.*

class MapsFragment : Fragment() {

    // to access the variable of other class, that class should have companion object defined with a variable
    // or
    // that variable should be public

    private val mapLocations = arrayListOf(
        MapLocationsDTO("IIT Roorkee"),
        MapLocationsDTO("Main Building"),
        MapLocationsDTO("Multi Activity Centre"),
        MapLocationsDTO("Bhawans"),
        MapLocationsDTO("Events Venue"),
        MapLocationsDTO("Hospital")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)

        return view
    }

    // now that the layout has been set, populate the views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        maps_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(DashboardActivity())
            // set the custom adapter to the RecyclerView
            adapter = MapsAdapter(mapLocations)
        }
    }


    companion object {
        fun newInstance(): MapsFragment = MapsFragment()
    }







    //        /*
//        MGCL library.
//         */
//        val mgclLibrary=findViewById(R.id.mgclLibrary) as Button;
//
//        val mapsLocations = arrayOf("geo:0,0?q=Mahatma Gandhi Central Library, Indian Institute of Technology,Thomason Marg, Roorkee, Uttarakhand 247667")
//
//        val mgclLibraryL = Uri.parse(mapsLocations[0])
//        val mapIntent = Intent(Intent.ACTION_VIEW, mgclLibraryL)
//        mapIntent.setPackage("com.google.android.apps.maps")
//
//        mgclLibrary.setOnClickListener {
//            if (mapIntent.resolveActivity(packageManager) != null) {
//                startActivity(mapIntent)
//            }
//        }
//
//        /*
//        MAC audi
//         */

}

