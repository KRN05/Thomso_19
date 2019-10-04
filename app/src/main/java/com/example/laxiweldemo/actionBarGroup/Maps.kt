package com.example.laxiweldemo.actionBarGroup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.MapsAdapter

class Maps : Activity() {

    // to access the variable of other class, that class should have companion object defined with a variable
    // or
    // that variable should be public

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    val mapLocations = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_maps)


        mapLocations.add("IIT Roorkee")
        mapLocations.add("Multi Activity Center")

        viewManager = LinearLayoutManager(this)
        viewAdapter = MapsAdapter(mapLocations)

        recyclerView = findViewById<RecyclerView>(R.id.maps_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter






























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
 }
}