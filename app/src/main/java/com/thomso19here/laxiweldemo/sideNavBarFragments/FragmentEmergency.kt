package com.thomso19here.laxiweldemo.sideNavBarFragments

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.thomso19here.laxiweldemo.R
import kotlinx.android.synthetic.main.fragment_emergency_2.*

class FragmentEmergency : Fragment() {

    companion object {
        fun newInstance(): FragmentEmergency =
            FragmentEmergency()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_emergency_2, container, false)


        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "EMERGENCY"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        //for crate home button
        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
               hospital location
         */
        val mHospital = view.findViewById(R.id.hospital) as ImageView;

        val mapsLocations =
            arrayOf("geo:0,0?q=IIT Hospital, IIT, Indian Institute of Technology Roorkee, Roorkee, Uttarakhand 247667")

        val mlHospital = Uri.parse(mapsLocations[0])
        val mapIntent = Intent(Intent.ACTION_VIEW, mlHospital)
        mapIntent.setPackage("com.google.android.apps.maps")

        mHospital.setOnClickListener {
            val packageManager: PackageManager = activity!!.packageManager
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }
        }


        anshu_singh.setOnClickListener {
            checkPermission(1)

        }

        anshu_singh_f.setOnClickListener {
            checkPermission(2)
        }

        ambulance.setOnClickListener {
            checkPermission(3)
        }


    }

    private fun checkPermission(eNum : Int) {
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CALL_PHONE
                )
            } != PackageManager.PERMISSION_GRANTED) {

            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.CALL_PHONE), 42
                )
            }
        } else {
            callPhone(eNum)
        }
    }


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

    fun callPhone(eNum: Int) {
        var numberPass : String?=null
        when(eNum){
            1->{
                numberPass="7302201760"
            }
            2->{
                numberPass="8795500000"
            }
            3->{
                numberPass="01332284260"
            }
        }


        val intent = Intent(ACTION_CALL, Uri.parse("tel:" + numberPass))
        startActivity(intent)
    }
}
