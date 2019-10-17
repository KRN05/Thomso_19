package com.thomso19here.laxiweldemo

import android.content.Context

class MySharedPreference(context: Context) {

    val PREFERENCE_NAME = "SharedPreference"

    val EVENTS_DAY_DATA = "EventsDayData"

    val BLANK_DEFAULT_VALUE =""

    val preference = context.getSharedPreferences(PREFERENCE_NAME, 0)

    fun getEventsData() : String?{
        return preference.getString(EVENTS_DAY_DATA,BLANK_DEFAULT_VALUE)
    }

    fun setEventsData(json :String){
        val editor = preference.edit()
        //stor json in this sharedpreference -> " preference" using editor and a key
        editor.putString(EVENTS_DAY_DATA, json)
        editor.apply()
    }
}