package com.example.laxiweldemo.adapters

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.laxiweldemo.bottomNavFragments.*


class DashboardTabAdapter (fm: FragmentManager?, private val bundle: Bundle?) : FragmentPagerAdapter(fm) {

    private var carnivalFragment: CarnivalFragment? = null
    private var eventsFragment: EventsFragment? = null
    private var homeFragment: HomeFragment? = null
    private var workshopsFragment: WorkshopsFragment? = null
    private var silentDjFragment: SilentDjFragment? = null

    private val TAB_COUNT = 5

    private val tabTitles = arrayOf("CARNIVAL", "EVENTS", "HOME", "WORKSHOPS", "SILENT DJ")


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CarnivalFragment.newInstance()
            }
            1 -> {
                return EventsFragment.newInstance()
            }
            2 -> {
                return HomeFragment.newInstance()
            }
            3 -> {
                return WorkshopsFragment.newInstance()
            }
            4-> {
                return SilentDjFragment.newInstance()
            }
            else -> {
                return HomeFragment.newInstance()
            }
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)

        when (position) {
            0 -> {
                if (fragment is CarnivalFragment) {
                    carnivalFragment = CarnivalFragment()
                }
            }
            1 -> {
                if (fragment is EventsFragment) {
                    eventsFragment = EventsFragment()
                }
            }
            2 -> {
                if (fragment is HomeFragment) {
                    homeFragment = HomeFragment()
                }
            }
            3 -> {
                if (fragment is WorkshopsFragment) {
                    workshopsFragment = WorkshopsFragment()
                }
            }
            4-> {
                if (fragment is SilentDjFragment){
                    silentDjFragment = SilentDjFragment()
                }
            }
            else -> {
                if (fragment is HomeFragment) {
                    homeFragment = HomeFragment()
                }
            }
        }

        return fragment
    }

    override fun getCount(): Int {
        return TAB_COUNT
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return tabTitles[position]
//    }

}
