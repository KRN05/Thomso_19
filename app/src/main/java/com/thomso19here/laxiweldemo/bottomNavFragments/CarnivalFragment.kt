package com.thomso19here.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thomso19here.laxiweldemo.R

class CarnivalFragment : Fragment(){

    companion object {
        fun newInstance(): CarnivalFragment =
            CarnivalFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_carnival, container, false)

    }
