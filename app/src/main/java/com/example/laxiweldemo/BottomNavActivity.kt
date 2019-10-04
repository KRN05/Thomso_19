package com.example.laxiweldemo

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.laxiweldemo.bottomNavFragments.SilentDjFragment

class BottomNavActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_silentdj -> {
                textMessage.setText(R.string.silent_dj)
                intent= Intent(applicationContext, SilentDjFragment::class.java)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_workshops -> {
                textMessage.setText(R.string.workshops)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)

        textMessage = findViewById(R.id.thisismsg)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
