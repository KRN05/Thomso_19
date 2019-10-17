package com.thomso19here.laxiweldemo.eventsDays

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.thomso19here.laxiweldemo.MySharedPreference
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.adapters.Day1Adapter
import com.thomso19here.laxiweldemo.dtos.EventsDTOArraylist
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.events_day1.*
import java.io.IOException
import java.nio.charset.Charset


class FragmentDay1 : Fragment() {

    companion object {
        fun newInstance(): FragmentDay1 =
            FragmentDay1()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.events_day1, container, false)

            return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedpreferences = context?.let { MySharedPreference(it) }

        //this loads data to shared preference
        loadJSONFromAsset()?.let { sharedpreferences?.setEventsData(it) }


        val jsonstr : String? = sharedpreferences?.getEventsData()
        Log.d("Json String",jsonstr)
        val gson = Gson()
        GsonBuilder().setPrettyPrinting().create()
        val eventsList: EventsDTOArraylist =  gson.fromJson(jsonstr, EventsDTOArraylist::class.java)

        /*
                adapter.setHasStableIds(true) will keep the ids stable on their position otherwise
                they move randomly on your scroll

                getItemId and getItemViewType are it's parts
         */

        val adapter = Day1Adapter(eventsList.EventsList)
        adapter.setHasStableIds(true)
        day1_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            day1_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = Day1Adapter(eventsList.EventsList)
        }
    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val fileJson = activity?.assets?.open("eventsList.json")
            val size = fileJson?.available()
            val buffer = size?.let { ByteArray(it) }
            fileJson?.read(buffer)
            fileJson?.close()
            json = buffer?.let { String(it, charset) }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}