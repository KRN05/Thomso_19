package com.example.laxiweldemo.bottomNavFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R
import kotlinx.android.synthetic.main.fragment_silentdj.*

class SilentDjFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_silentdj, container, false)

        return view
    }

    companion object {
        fun newInstance(): SilentDjFragment =
            SilentDjFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        silent_dj_pay_now.setOnClickListener(){
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.thomso.in")
            startActivity(openURL)
        }


    }
}