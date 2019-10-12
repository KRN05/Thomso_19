package com.example.laxiweldemo.actionBarGroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laxiweldemo.R
import com.example.laxiweldemo.adapters.FaqAdapter
import com.example.laxiweldemo.dtos.FaqDTO
import kotlinx.android.synthetic.main.activity_faqs.*
import android.view.MenuItem


class ActivityFaq : AppCompatActivity() {

    val faqNum= arrayListOf(
        FaqDTO("What is the", "Create an ArrayList and add a bunch of animals to the list.\n" +
                "Add a LinearLayoutManager. Layout Managers are used to position views inside the RecyclerView. They also determine when to reuse item views that are no longer visible to the user.\n" +
                "(You can use GridLayoutManager instead of LinearLayoutManager if you want a grid layout and add the number of columns as a parameter)")
    )


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


        faq_recycler_view.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        faq_recycler_view.adapter = FaqAdapter(faqNum)
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