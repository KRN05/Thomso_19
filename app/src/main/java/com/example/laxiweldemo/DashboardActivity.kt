package com.example.laxiweldemo

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
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
import com.example.laxiweldemo.adapters.DashboardTabAdapter
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.laxiweldemo.actionBarGroup.ActivityFaq
import com.example.laxiweldemo.sideNavBarFragments.*
import kotlinx.android.synthetic.main.dashboard_activity.*


//NavigationView.OnNavigationItemSelectedListener


class DashboardActivity : AppCompatActivity(), ViewPager.OnPageChangeListener,
    NavigationView.OnNavigationItemSelectedListener {

    private var dashboardTabAdapter: DashboardTabAdapter? = null

    val bottomTabIcon = arrayOf(
        R.drawable.ic_carnival_icon,
        R.drawable.ic_events_icon,
        R.drawable.ic_home_icon,
        R.drawable.ic_workshops,
        R.drawable.ic_silent_dj
    )

    val bottomTabIconSelected = arrayOf(
        R.drawable.ic_carnival_colored,
        R.drawable.ic_carnival_colored,
        R.drawable.ic_carnival_colored,
        R.drawable.ic_carnival_colored,
        R.drawable.ic_carnival_colored
    )


    val navLabels = arrayOf(
        R.string.carnival,
        R.string.events,
        R.string.title_home,
        R.string.workshops,
        R.string.silent_dj
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

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

        // my_child_toolbar is defined in the layout file
       // setSupportActionBar(findViewById(R.id.my_child_toolbar))

        // Get a support ActionBar corresponding to this toolbar and enable the Up button
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
                openURL.data = Uri.parse("https://www.thomso.in")
                startActivity(openURL)

            }
            R.id.nav_maps -> {

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
                val sponsorsFragment = FragmentSponsors.newInstance()
                openFragment(sponsorsFragment)
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
    @RequiresApi(Build.VERSION_CODES.M)
    private fun doInitialSetup() {
        setUpTabAdapter()
//        setUpTabIcons()
    }

//    private fun setUpTabIcons(){
//        bottomTabLayout.getTabAt(0)?.setIcon(bottomTabIcon[0]);
//        bottomTabLayout.getTabAt(1)?.setIcon(bottomTabIcon[1]);
//        bottomTabLayout.getTabAt(2)?.setIcon(bottomTabIcon[2]);
//        bottomTabLayout.getTabAt(3)?.setIcon(bottomTabIcon[3]);
//        bottomTabLayout.getTabAt(4)?.setIcon(bottomTabIcon[4]);
//
//    }

    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setUpTabAdapter() {
        dashboardTabAdapter = DashboardTabAdapter(supportFragmentManager, intent.extras)
        viewpager_dashboard.adapter = dashboardTabAdapter
        viewpager_dashboard.offscreenPageLimit = 4
        bottomTabLayout.setupWithViewPager(viewpager_dashboard)


        for (i in 0 until bottomTabLayout.getTabCount()) {
            // inflate the Parent LinearLayout Container for the tab
            // from the layout nav_tab.xml file that we created 'R.layout.nav_tab
            val tab = LayoutInflater.from(this).inflate(
                R.layout.list_bottom_tab_layout,
                null
            ) as LinearLayout

            // get child TextView and ImageView from this layout for the icon and label
            val tab_label = tab.findViewById(R.id.nav_label) as TextView
            val tab_icon = tab.findViewById(R.id.nav_icon) as ImageView

            // set the label text by getting the actual string value by its id
            // by getting the actual resource value `getResources().getString(string_id)`
            tab_label.text = resources.getString(navLabels[i])

            // set the home to be active at first
            if (i == 0) {
                tab_label.setTextColor(resources.getColor(R.color.colorPrimary, theme));
                tab_icon.setImageResource(bottomTabIconSelected[i])
            } else {
                tab_icon.setImageResource(bottomTabIcon[i])
            }

            // finally publish this custom view to navigation tab
            bottomTabLayout.getTabAt(i)?.customView = tab
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
                val teamFragment = FragmentTeam.newInstance()
                openFragment(teamFragment)
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
