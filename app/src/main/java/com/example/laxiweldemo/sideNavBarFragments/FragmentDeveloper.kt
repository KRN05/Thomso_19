package com.example.laxiweldemo.sideNavBarFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R
import kotlinx.android.synthetic.main.fragment_developer_2.*

class FragmentDeveloper : Fragment() {

    companion object {
        fun newInstance(): FragmentDeveloper =
            FragmentDeveloper()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_developer_2, container, false)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "DEVELOPER"

        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        //for crate home button
        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linkedin.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.linkedin.com/in/karan-bobade-1a13ab160")
            startActivity(openURL)
        }

        github.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/KRN05")
            startActivity(openURL)
        }

        facebook.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.facebook.com/KRNbde")
            startActivity(openURL)
        }
    }
}