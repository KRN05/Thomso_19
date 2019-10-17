package com.thomso19here.laxiweldemo.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.thomso19here.laxiweldemo.eventsDays.FragmentDay1
import com.thomso19here.laxiweldemo.eventsDays.FragmentDay2
import com.thomso19here.laxiweldemo.eventsDays.FragmentDay3
import com.thomso19here.laxiweldemo.eventsDays.FragmentOnGoing

/*
    this will take fragment manager as a parameter
*/
class EventDayStatusTabAdapter(efm: FragmentManager?, private var activePosition: Int?) :
    FragmentPagerAdapter(efm) {

    private val TAG = javaClass.name

    private var onGoing: FragmentOnGoing? = null
    private var day1: FragmentDay1? = null
    private var day2: FragmentDay2? = null
    private var day3: FragmentDay3? = null


    private val TAB_COUNT = 4

    private val tabTitles = arrayOf("ONGOING", "DAY 1", "DAY 2", "DAY 3")

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentOnGoing.newInstance()
            }
            1 -> {
                return FragmentDay1.newInstance()
            }
            2 -> {
                return FragmentDay2.newInstance()
            }
            3 -> {
                return FragmentDay3.newInstance()
            }
            else -> {
                return FragmentOnGoing.newInstance()
            }
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)

        when (position) {
            0 -> {
                if (fragment is FragmentOnGoing) {
                    onGoing = FragmentOnGoing()
                }
            }
            1 -> {
                if (fragment is FragmentDay1) {
                    day1 = FragmentDay1()
                }
            }
            2 -> {
                if (fragment is FragmentDay2) {
                    day2 = FragmentDay2()
                }
            }
            3 -> {
                if (fragment is FragmentDay3) {
                    day3 = FragmentDay3()
                }
            }
            else -> {
                if (fragment is FragmentOnGoing) {
                    onGoing = FragmentOnGoing()
                }
            }
        }

        return fragment
    }

    override fun getCount(): Int {
        return TAB_COUNT
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}