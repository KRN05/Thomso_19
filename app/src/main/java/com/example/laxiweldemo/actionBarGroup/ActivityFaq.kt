package com.example.laxiweldemo.actionBarGroup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.FaqAdapter
import com.example.laxiweldemo.dtos.FaqDTO
import kotlinx.android.synthetic.main.activity_faqs.*
import android.view.MenuItem
import com.example.laxiweldemo.dtos.FaqDTOArraylist
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.nio.charset.Charset


class ActivityFaq : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqs)

        /*
         to use customized toolbar first declare android:theme="@style/AppTheme.NoActionBar"
         in android manifest for this activity and then use below code
         */
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title="FAQs"
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val jsonstr : String? = loadJSONFromAsset()
        Log.d("Json String",jsonstr)
        val gson = Gson()
        GsonBuilder().setPrettyPrinting().create()
        val mFaqs: FaqDTOArraylist =  gson.fromJson(jsonstr, FaqDTOArraylist::class.java)
        Log.d("Team List", mFaqs.toString())


        faq_recycler_view.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        faq_recycler_view.adapter = FaqAdapter(mFaqs.FaqDetails)
    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val fileJson = assets?.open("faqs.json")
            val size = fileJson?.available()
            val buffer = size?.let { ByteArray(it) }
            fileJson?.read(buffer)
            fileJson?.close()
            json = buffer?.let { String(it, charset) }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }


    //this will bring the toolbar back button in action, without this it will not go back
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}