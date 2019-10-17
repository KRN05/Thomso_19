package com.thomso19here.laxiweldemo.bottomNavFragments
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.thomso19here.laxiweldemo.R
import com.thomso19here.laxiweldemo.adapters.WorkshopsAdapter
import com.thomso19here.laxiweldemo.dtos.WorkshopsDTO
import kotlinx.android.synthetic.main.fragment_workshops.*

import kotlinx.android.synthetic.main.fragment_workshops.view.workshops_recycler_view
import com.thomso19here.laxiweldemo.RecyclerItemClickListener


class WorkshopsFragment : Fragment() {

    var workshopsList = arrayListOf(
        WorkshopsDTO(R.drawable.ic_ai, "AI & ML", R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_motor_sports, "Motor Sports Engineering",R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_digital_marketing, "Digital Marketing", R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_fusion_robotics, "Fusion Robotics", R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_ethical_hacking, "Ethical Hacking", R.drawable.ic_pay_now),
        WorkshopsDTO(R.drawable.ic_animation_and_dt, "Animation and Design Thinking", R.drawable.ic_free_now),
        WorkshopsDTO(R.drawable.ic_sketching, "Sketching ", R.drawable.ic_free_now),
        WorkshopsDTO(R.drawable.ic_pg, "Photography ", R.drawable.ic_free_now)
    )

    companion object {
        fun newInstance(): WorkshopsFragment =
            WorkshopsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_workshops, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workshops_recycler_view.apply {

            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            workshops_recycler_view.
            adapter = WorkshopsAdapter(workshopsList) // set the custom adapter to the RecyclerView
        }

        workshops_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                workshops_recycler_view,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onLongItemClick(view: View?, position: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onItemClick(view: View, position: Int) {
                        // do whatever
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://www.townscript.com/e/thomso-workshops-212202")
                        startActivity(openURL)
                    }
                })
        )
    }

}