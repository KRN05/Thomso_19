package com.example.laxiweldemo.bottomNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.laxiweldemo.DashboardActivity
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.EventDayStatusTabAdapter
import kotlinx.android.synthetic.main.fragment_events.*


class EventsFragment : Fragment(), ViewPager.OnPageChangeListener {

    private var eventDayStatusTabAdapter: EventDayStatusTabAdapter? = null
    protected lateinit var mActivity: AppCompatActivity


    companion object {
        fun newInstance(): EventsFragment =
            EventsFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        mActivity = activity as DashboardActivity

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doInitialSetup()
    }

    private fun doInitialSetup() {
        setUpEventsTabAdapter()
    }


    private fun setUpEventsTabAdapter() {
        val subTab = arguments?.getString("extraSubSection")
        val activeTabPosition = when (subTab) {
            "onGoing" -> 0
            "events_day1" -> 1
            "events_day2" -> 2
            "day"  -> 3
             else->   0
        }

        eventDayStatusTabAdapter = EventDayStatusTabAdapter(
            childFragmentManager, activeTabPosition
        )
        event_viewpager_2.adapter = eventDayStatusTabAdapter

        //this is must for viewpager to work and enabling this will take out NAMES that you declared in xml
        events_tablayout_2.setupWithViewPager(event_viewpager_2)

        event_viewpager_2.addOnPageChangeListener(this)
        events_tablayout_2.getTabAt(activeTabPosition)?.select()

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