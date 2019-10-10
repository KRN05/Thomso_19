package com.example.laxiweldemo

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
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.laxiweldemo.sideNavBarFragments.FragmentTeam
import kotlinx.android.synthetic.main.side_nav_activity.*


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
        setContentView(R.layout.side_nav_activity)

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
        toggle.syncState()

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
                openURL.data = Uri.parse("https://www.thomso.in")
                startActivity(openURL)

            }
            R.id.nav_maps -> {

            }
            R.id.nav_food_n_beverages -> {

            }
            R.id.nav_team -> {
                val teamFragment = FragmentTeam.newInstance()
                openFragment(teamFragment)
            }
            R.id.nav_developer -> {

            }
            R.id.nav_sponsors -> {

            }
            R.id.nav_emergency -> {

            }
        }
        val drawerLayout: DrawerLayout =
            findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
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
}
