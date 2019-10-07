package com.example.laxiweldemo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.laxiweldemo.actionBarGroup.FaqsFragment
import com.example.laxiweldemo.actionBarGroup.MapsFragment
import com.example.laxiweldemo.adapters.DashboardTabAdapter
import com.example.laxiweldemo.adapters.EventDayStatusTabAdapter
import com.example.laxiweldemo.bottomNavFragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.dashboard_activity.*
import kotlinx.android.synthetic.main.fragment_events.*


//NavigationView.OnNavigationItemSelectedListener


class DashboardActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    protected lateinit var mActivity: AppCompatActivity
    private lateinit var textMessage: TextView

    private val CARNIVAL_TAB = 0
    private val EVENTS_TAB = 1
    private val HOME_TAB = 2
    private val WORKSHOPS_TAB = 3
    private val SILENTDJ_TAB = 4

    private var dashboardTabAdapter: DashboardTabAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        doInitialSetup()
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        textMessage = findViewById(R.id.thisismsg)
//        setSupportActionBar(toolbar)
//
//
//        /*
//              SIDE NAV
//         */
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val sideNavView: NavigationView = findViewById(R.id.side_nav_view)
//        val toggle = ActionBarDrawerToggle(
//            this,
//            drawerLayout,
//            toolbar,
//            R.string.navigation_drawer_open,
//            R.string.navigation_drawer_close
//        )
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        sideNavView.setNavigationItemSelectedListener(this)
//
//        /*
//               BOTTOM NAV
//         */
//
//        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
//        bottomNavView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
//
//        //this will set home as a default tab
//        bottomNavView.selectedItemId = R.id.navigation_home
//
//        //in case long labels are there and they hide on selection, you don't want them to hide, then
//            //  val largeTextView : TextView = findViewById(R.id.navigation_workshops)
//            //            largeTextView.findViewById<TextView>(com.google.android.material.R.id.largeLabel)
//            //
//            //        val smallTextView : TextView =  findViewById(R.id.navigation_workshops)
//            //            smallTextView.findViewById<TextView>(com.google.android.material.R.id.smallLabel)
//            //
//            //            smallTextView.visibility= View.VISIBLE
//            //            largeTextView.visibility=View.GONE
//

    }

//    override fun onBackPressed() {
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.action_bar_items, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.top_maps -> {
//
//                intent=Intent(applicationContext, MapsFragment::class.java)
//                startActivity(intent)
////                val mapsFragment = MapsFragment.newInstance()
////                openFragment(mapsFragment)
//                return true
//            }
//            R.id.top_faqs -> {
//
//                val faqsFragment = FaqsFragment.newInstance()
//                openFragment(faqsFragment)
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    /*
       for SIDE NAV
     */
//
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        // Handle navigation view item clicks here.
//        when (item.itemId) {
//            R.id.nav_makePayment -> {
//
//            }
//            R.id.nav_maps -> {
//
//            }
//            R.id.nav_food_n_beverages -> {
//
//            }
//            R.id.nav_team -> {
//
//            }
//            R.id.nav_developer -> {
//
//            }
//        }
//        val drawerLayout: DrawerLayout =
//            findViewById(R.id.drawer_layout)
//        drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

    /*
        for  BOTTOM NAV
     */
//    private val onNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_carnival -> {
//                    textMessage.setText(R.string.title_home)
//                    val carnivaljFragment = CarnivalFragment.newInstance()
//                    openFragment(carnivaljFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_events -> {
//                    textMessage.setText(R.string.title_home)
//                    val eventsFragment = EventsFragment.newInstance()
//                    openFragment(eventsFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_home -> {
//                    textMessage.setText(R.string.title_home)
//                    val homeFragment = HomeFragment.newInstance()
//                    openFragment(homeFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_workshops -> {
//                    textMessage.setText(R.string.workshops)
//                    val workshopsjFragment = WorkshopsFragment.newInstance()
//                    openFragment(workshopsjFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_silentdj -> {
//                    textMessage.setText(R.string.silent_dj)
//                    val silentDjFragment = SilentDjFragment.newInstance()
//                    openFragment(silentDjFragment)
//                    return@OnNavigationItemSelectedListener true
//                }
//
//            }
//            false
//            /* this OnNavigationItemSelectedListener is by default false, as it is stated on last line
//                so what does it do?
//                when you click on another tab, you can see it being highlighted,
//                this is possible when OnNavigationItemSelectedListener is true,
//                if this is false, you will see the changes but will not see that tab icon highlighted
//             */
//        }


    // for fragment transaction, that allows you to use intent feature for fragment

//    private fun openFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }



    private fun doInitialSetup() {
        setUpTabAdapter()
    }


    private fun setUpTabAdapter() {
        dashboardTabAdapter = DashboardTabAdapter(supportFragmentManager, intent.extras)
        viewpager_dashboard.adapter = dashboardTabAdapter
        viewpager_dashboard.offscreenPageLimit = 4
        bottomTabLayout.setupWithViewPager(viewpager_dashboard)
        bottomTabLayout.removeAllTabs()

        val drawableArray = arrayOf(
            R.drawable.ic_carnival_icon,
            R.drawable.ic_events_icon,
            R.drawable.ic_home_icon,
            R.drawable.ic_workshops,
            R.drawable.ic_silent_dj
        )

//        dashboardTabAdapter?.let {
//            for (i in 0 until it.count) {
//                val tab = bottomTabLayout.newTab()
//                val tabName = mActivity.layoutInflater.inflate(R.layout.tab, bottomTabLayout, false) as TextView
//                tabName.text = resources.getStringArray(R.array.dashboardTabsNames)[i]
//                tabName.setCompoundDrawablesWithIntrinsicBounds(0, drawableArray[i], 0, 0)
//                tab.customView = tabName
//                bottomTabLayout.addTab(tab, i, i == HOME_TAB)
//
//            }
//        }

        viewpager_dashboard.addOnPageChangeListener(this)
    }






    override fun onPageScrollStateChanged(state: Int) {
        //do nothing
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        //do nothing
    }

    override fun onPageSelected(position: Int) {
        //do nothing
    }
}
