package com.example.laxiweldemo.eventsDays

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laxiweldemo.R
import kotlinx.android.synthetic.main.event_overview.*


class EventOverview : AppCompatActivity() {

    private val TAG = "GalleryActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_overview)

        Log.d(TAG, "onCreate started")

        getIncomingIntent()
    }

    private fun getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.")

        if (intent.hasExtra("event_name") && intent.hasExtra("event_des") && intent.hasExtra("event_start") && intent.hasExtra(
                "event_end"
            ) && intent.hasExtra("event_cod") && intent.hasExtra("event_cod_no") && intent.hasExtra(
                "event_location"
            )
        ) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            val eventName = intent.getStringExtra("event_name")
            val eventDes = intent.getStringExtra("event_des")
            val eventStart = intent.getStringExtra("event_start")
            val eventEnd = intent.getStringExtra("event_end")
            val eventCod = intent.getStringExtra("event_cod")
            val eventCodNo = intent.getStringExtra("event_cod_no")
            val eventLocation = intent.getStringExtra("event_location")

            setEventOverview(
                eventName,
                eventDes,
                eventStart,
                eventEnd,
                eventCod,
                eventCodNo,
                eventLocation
            )
        }
    }

    private fun setEventOverview(
        eventName: String,
        eventDes: String,
        eventStart: String,
        eventEnd: String,
        eventCod: String,
        eventCodNo: String,
        eventLocation: String
    ) {
        event_overview_title.text = eventName.toUpperCase()
        event_overview_des.text = eventDes
        event_overview_time.text = getString(R.string.eventOverviewTime, eventStart, eventEnd)
        event_overview_coord.text = getString(R.string.eventCod, eventCod)
        event_overview_coord_no.text = getString(R.string.eventContact, eventCodNo)
        event_overview_location.text = getString(R.string.eventLocation, eventLocation)

    }
}
