package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.EventDayStatusTabAdapter
import kotlinx.android.synthetic.main.fragment_events.*

class EventsFragment : Fragment(), ViewPager.OnPageChangeListener {

    private var eventDayStatusTabAdapter: EventDayStatusTabAdapter? = null


    companion object {
        fun newInstance(): EventsFragment =
            EventsFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doInitialSetup()
    }

    private fun doInitialSetup() {
        setUpLoanStatusTabAdapter()
    }


    private fun setUpLoanStatusTabAdapter() {
        val subTab = arguments?.getString("extraSubSection")
        val activeTabPosition = when (subTab) {
            "onGoing" -> 0
            "day1" -> 1
            "day2" -> 2
            "day"  -> 3
             else-> 0
        }

        eventDayStatusTabAdapter = EventDayStatusTabAdapter(
            childFragmentManager, activeTabPosition
        )
        eventsViewPager.adapter = eventDayStatusTabAdapter
        eventsTabLayout.setupWithViewPager(eventsViewPager)


        eventsViewPager.addOnPageChangeListener(this)
        eventsTabLayout.getTabAt(activeTabPosition)?.select()
    }





    override fun onPageScrollStateChanged(state: Int) {
        //Do nothing
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        //Do nothing
    }

    override fun onPageSelected(position: Int) {
        //Do nothing
    }

}