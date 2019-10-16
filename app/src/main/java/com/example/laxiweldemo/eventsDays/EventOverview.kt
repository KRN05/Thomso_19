package com.example.laxiweldemo.eventsDays

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.laxiweldemo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
            ) && (intent.hasExtra("event_lat") && (intent.hasExtra("event_long")))
        ) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            val eventName = intent.getStringExtra("event_name")
            val eventDes = intent.getStringExtra("event_des")
            val eventStart = intent.getStringExtra("event_start")
            val eventEnd = intent.getStringExtra("event_end")
            val eventCod = intent.getStringExtra("event_cod")
            val eventCodNo = intent.getStringExtra("event_cod_no")
            val eventLocation = intent.getStringExtra("event_location")
            val eventLat = intent.getStringArrayExtra("event_lat")
            val eventLong = intent.getStringArrayExtra("event_long")

            setEventOverview(
                eventName,
                eventDes,
                eventStart,
                eventEnd,
                eventCod,
                eventCodNo,
                eventLocation
            )


//            clickEvents(eventCodNo, eventLocation)
            if (eventCod != null) {
                cod_no.setOnClickListener {
                    checkPermissionCall(eventCodNo)
                }
            }


            val eventLocRedirect = findViewById<FloatingActionButton>(R.id.event_ov_location)
//            val mapsLocations =
//                arrayOf("geo:0,0?q=IIT Hospital, IIT, Indian Institute of Technology Roorkee, Roorkee, Uttarakhand 247667")

            if (eventLat != null && eventLong != null) {
                val mlEvent = Uri.parse("google.navigation:q=$eventLat,$eventLong&mode=w")
                val mapIntent = Intent(Intent.ACTION_VIEW, mlEvent)
                mapIntent.setPackage("com.google.android.apps.maps")

                eventLocRedirect.setOnClickListener {
                    val packageManager: PackageManager = packageManager
                    if (mapIntent.resolveActivity(packageManager) != null) {
                        startActivity(mapIntent)
                    }
                }
            }


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


    //
//    /*
//    call permission
//     */
    private fun checkPermissionCall(eventCodNo: String) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                42
            )

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        } else {
            val intent =
                Intent(Intent(ACTION_CALL, Uri.parse("tel:" + eventCodNo.substring(0, 10))))
            startActivity(intent)
        }
    }

    //
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == 42) {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay! do the call related action u wanted to do
                //callPhone(eNum)
            } else {
                // permission denied, boo! Disable the
                // functionality
            }
            return
        }
    }
}