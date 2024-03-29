package com.thomso19here.laxiweldemo.sideNavBarFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.adapters.TeamAdapter
import kotlinx.android.synthetic.main.fragment_team.*

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.thomso19here.laxiweldemo.dtos.TeamDTOArrayList
import com.thomso19here.laxiweldemo.dtos.TeamPhotoDTO
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.nio.charset.Charset

//import kotlinx.serialization.*
//import kotlinx.serialization.json.*

class FragmentTeam : Fragment() {

    val teamPhoto = arrayListOf(
        TeamPhotoDTO(R.drawable.ic_launcher)
    )

    companion object {
        fun newInstance(): FragmentTeam =
            FragmentTeam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_team, container, false)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        toolbar.title="TEAM"

        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        //for crate home button
        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonstr : String? = loadJSONFromAsset()
        Log.d("Json String",jsonstr)
        val gson = Gson()
        GsonBuilder().setPrettyPrinting().create()
        val teamMembers: TeamDTOArrayList =  gson.fromJson(jsonstr,TeamDTOArrayList::class.java)
        Log.d("Team List", teamMembers.toString())
        team_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 1) as RecyclerView.LayoutManager?
            team_recycler_view.
                // set the custom adapter to the RecyclerView
                adapter = TeamAdapter(teamMembers.TeamDetails)
        }
    }
    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val fileJson = activity?.assets?.open("teamdetails.json")
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