package com.example.laxiweldemo


//in on create method

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




//outside oncreate method
/*
       for  BOTTOM NAV
    */
//    private val onNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_carnival -> {
//                    textMessage.setText(R.string.title_home)
//                    val carnivaljFragment = CarnivalAdapter.newInstance()
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




/*
Fragment Transaction -- for fragment transaction, that allows you to use intent feature for fragment
 */


//    private fun openFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
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
//                val faqsFragment = ActivityFaq.newInstance()
//                openFragment(faqsFragment)
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
