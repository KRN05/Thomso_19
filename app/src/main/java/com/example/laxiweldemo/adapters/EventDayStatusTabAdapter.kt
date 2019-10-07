package com.example.laxiweldemo.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.laxiweldemo.eventsDays.Day1
import com.example.laxiweldemo.eventsDays.Day2
import com.example.laxiweldemo.eventsDays.Day3
import com.example.laxiweldemo.eventsDays.OnGoing

/*
    this will take fragment manager as a parameter
*/
class EventDayStatusTabAdapter(efm: FragmentManager?, private var activePosition: Int?) :
    FragmentPagerAdapter(efm) {

    private val TAG = javaClass.name

    private var onGoing: OnGoing? = null
    private var day1: Day1? = null
    private var day2: Day2? = null
    private var day3: Day3? = null


    private val TAB_COUNT = 4

    private val tabTitles = arrayOf("ONGOING", "DAY 1", "DAY 2", "DAY 3")

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return OnGoing.newInstance()
            }
            1 -> {
                return Day1.newInstance()
            }
            2 -> {
                return Day2.newInstance()
            }
            3 -> {
                return Day3.newInstance()
            }
            else -> {
                return OnGoing.newInstance()
            }
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)

        when (position) {
            0 -> {
                if (fragment is OnGoing) {
                    onGoing = OnGoing()
                }
            }
            1 -> {
                if (fragment is Day1) {
                    day1 = Day1()
                }
            }
            2 -> {
                if (fragment is Day2) {
                    day2 = Day2()
                }
            }
            3 -> {
                if (fragment is Day3) {
                    day3 = Day3()
                }
            }
            else -> {
                if (fragment is OnGoing) {
                    onGoing = OnGoing()
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