package com.example.laxiweldemo.sideNavBarFragments

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.Intent.parseUri
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.DashboardActivity
import com.example.laxiweldemo.R
import kotlinx.android.synthetic.main.fragment_emergency.*

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
        val view = inflater.inflate(R.layout.fragment_emergency, container, false)


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


        ambulance.setOnClickListener {
            checkPermission()
        }
        anshu_singh.setOnClickListener {
            checkPermission()

        }

        anshu_singh_f.setOnClickListener {
            checkPermission()
        }

        hospital_icon.setOnClickListener {

        }


    }

    private fun checkPermission() {
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CALL_PHONE
                )
            } != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(context,"Allow Phone calls",LENGTH_SHORT).show()
        } else {
            callPhone()
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == 42) {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay!
                callPhone()
            } else {
                // permission denied, boo! Disable the
                // functionality
            }
            return
        }
    }

    fun callPhone() {
        val intent = Intent(ACTION_CALL, Uri.parse("tel:" + "7218689420"))
        startActivity(intent)
    }
}
