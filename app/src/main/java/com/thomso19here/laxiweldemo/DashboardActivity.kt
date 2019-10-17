package com.thomso19here.laxiweldemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.thomso19here.laxiweldemo.adapters.DashboardTabAdapter
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import com.thomso19here.laxiweldemo.actionBarGroup.ActivityFaq
import com.thomso19here.laxiweldemo.actionBarGroup.MapsFragment
import com.thomso19here.laxiweldemo.sideNavBarFragments.*
import kotlinx.android.synthetic.main.dashboard_activity.*


//NavigationView.OnNavigationItemSelectedListener


class DashboardActivity : AppCompatActivity(), ViewPager.OnPageChangeListener,
    NavigationView.OnNavigationItemSelectedListener {

    private var dashboardTabAdapter: DashboardTabAdapter? = null

    protected lateinit var mActivity: AppCompatActivity

    private val CARNIVAL_TAB = 0
    private val EVENTS_TAB = 1
    private val HOME_TAB = 2
    private val WORKSHOP_TAB = 3
    private val SILENTDJ_TAB = 4


    val bottomTabIcon = arrayOf(
        R.drawable.selector_tab_carnival,
        R.drawable.selector_tab_events,
        R.drawable.selector_tab_home,
        R.drawable.selector_tab_workshop,
        R.drawable.selector_tab_silentdj
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        mActivity = this

        doInitialSetup()

        val toolbar: Toolbar = findViewById(R.id.toolbarSideNav)
        setSupportActionBar(toolbar)


        /*
              SIDE NAV
         */
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val sideNavView: NavigationView = findViewById(R.id.side_nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.setDrawerIndicatorEnabled(false);

        toggle.setToolbarNavigationClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        })

        toggle.setHomeAsUpIndicator(R.drawable.ic_hamberger);
        toggle.syncState()

        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        sideNavView.setNavigationItemSelectedListener(this)

    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    /*
       for SIDE NAV
     */

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_makePayment -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.townscript.com/e/thomso-424321")
                startActivity(openURL)

            }
            R.id.nav_result -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.facebook.com/thomsoiitroorkee")
                startActivity(openURL)
            }
            R.id.nav_food_n_beverages -> {
                val foodnBeveragesFragment = FragmentFoodnBeverages.newInstance()
                openFragment(foodnBeveragesFragment)
            }
            R.id.nav_team -> {
                val teamFragment = FragmentTeam.newInstance()
                openFragment(teamFragment)
            }
            R.id.nav_developer -> {
                val developerFragment = FragmentDeveloper.newInstance()
                openFragment(developerFragment)
            }
            R.id.nav_sponsors -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.thomso.in/sponsors")
                startActivity(openURL)
            }
            R.id.nav_emergency -> {
                val EmergencyFragment = FragmentEmergency.newInstance()
                openFragment(EmergencyFragment)
            }
        }
        val drawerLayout: DrawerLayout =
            findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    /*
        Bottom Tab layout setup
     */
    private fun doInitialSetup() {
        setUpTabAdapter()
    }

    private fun setUpTabAdapter() {
        dashboardTabAdapter = DashboardTabAdapter(supportFragmentManager, intent.extras)
        viewpager_dashboard.adapter = dashboardTabAdapter
        viewpager_dashboard.offscreenPageLimit = 4
        bottomTabLayout.setupWithViewPager(viewpager_dashboard)
        bottomTabLayout.removeAllTabs()

        dashboardTabAdapter?.let {
            for (i in 0 until it.count) {
                val tab = bottomTabLayout.newTab()
                val tabName = mActivity.layoutInflater.inflate(
                    R.layout.tab,
                    bottomTabLayout,
                    false
                ) as TextView
                tabName.text = resources.getStringArray(R.array.dashboardTabsNames)[i]
                tabName.setCompoundDrawablesWithIntrinsicBounds(0, bottomTabIcon[i], 0, 0)
                tab.customView = tabName
                bottomTabLayout.addTab(tab, i, i == HOME_TAB)
            }
        }

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


    /*
          Action Bar items
     */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_items, menu)

        val searchItem = menu?.findItem(R.id.top_maps)
        // val searchView = searchItem?.actionView as SearchView

        // Configure the search info and add any event listeners...

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.top_maps -> {
                intent = Intent(applicationContext, MapsFragment::class.java)
                startActivity(intent)
                return true
            }

            R.id.top_faqs -> {
                intent = Intent(applicationContext, ActivityFaq::class.java)
                startActivity(intent)
                return true
            }

            android.R.id.home -> {
                onBackPressed()
                return true
            }

            //this will bring in action the back button for ALL THE FRAGMENTS ATTACHED WITH THIS ACTIVITY AND HAVING BACK BUTTON
            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }
        }
        return true
    }


    /*
        Fragment Transaction -- for fragment transaction, that allows you to use intent feature for fragment
    */
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
