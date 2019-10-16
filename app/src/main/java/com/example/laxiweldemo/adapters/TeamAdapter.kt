package com.example.laxiweldemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.TeamDTO
import com.example.laxiweldemo.viewHolders.TeamViewHolder
import kotlinx.android.synthetic.main.list_team.view.*


class TeamAdapter(
    private val teamInfo: ArrayList<TeamDTO>
) :
    RecyclerView.Adapter<TeamViewHolder>() {

    val xyz = arrayListOf<Int>(
        R.drawable.rohit,
        R.drawable.harshit_2,
        R.drawable.rana_2,
        R.drawable.ayush_2,
        R.drawable.manu_2,
        R.drawable.pulkit_2,
        R.drawable.tanishq,
        R.drawable.saakshya_2,
        R.drawable.rupali_2,
        R.drawable.abdul_2,
        R.drawable.jivesh_2,
        R.drawable.abhay_2,
        R.drawable.vivek_2,
        R.drawable.satyam,
        R.drawable.nikhil_2,
        R.drawable.mayan_2,
        R.drawable.shreyansh,
        R.drawable.harsh_2
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TeamViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val workshops: TeamDTO = teamInfo[position]
        holder.bind(workshops)


        holder.itemView.team_photo.setImageResource(xyz[position])

    }


    override fun getItemCount(): Int = teamInfo.size

}