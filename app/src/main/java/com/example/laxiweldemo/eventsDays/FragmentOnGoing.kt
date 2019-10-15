package com.example.laxiweldemo.eventsDays

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.OngoingAdapter
import com.example.laxiweldemo.adapters.OngoingAdapter2
import com.example.laxiweldemo.dtos.EventsDTO
import com.example.laxiweldemo.dtos.EventsDTOArraylist
import com.example.laxiweldemo.dtos.OngoingDTO
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.events_day1.*
import kotlinx.android.synthetic.main.events_ongoing.*
import kotlinx.android.synthetic.main.events_ongoing_list.view.*
import java.io.IOException
import java.nio.charset.Charset

class FragmentOnGoing : Fragment() {

    val mActivity : AppCompatActivity?=null

    companion object {
        fun newInstance(): FragmentOnGoing {
            val fragmentHome = FragmentOnGoing()
            val bundle = Bundle()
            fragmentHome.arguments = bundle
            return fragmentHome
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.events_ongoing, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val jsonstr : String? = loadJSONFromAsset()
        Log.d("Json String",jsonstr)
        val gson = Gson()
        GsonBuilder().setPrettyPrinting().create()
        val eventsList: EventsDTOArraylist =  gson.fromJson(jsonstr, EventsDTOArraylist::class.java)

        ongoing_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1)
            ongoing_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = OngoingAdapter(eventsList.EventsList)
        }
    }

    private val onEventClickListener: OnItemClickListener<EventsDTO>? =
        object : OnItemClickListener<EventsDTO> {
            override fun onItemClick(item: EventsDTO) {
                val loanDetails = Intent(mActivity, EventOverview::class.java)
                startActivity(loanDetails)

//                loanDetails.putExtra(AppConstants.EXTRAS_CONTACT_INFO, item)
//                (activity as BaseAppCompactActivity).startActivityOnTop(loanDetails, false)
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