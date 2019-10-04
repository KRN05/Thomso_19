package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.R

class SilentDjFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_silentdj, container, false)

    companion object {
        fun newInstance(): SilentDjFragment =
            SilentDjFragment()
    }
}