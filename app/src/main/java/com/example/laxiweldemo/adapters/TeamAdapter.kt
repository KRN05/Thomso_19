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
        R.drawable.harshit,
        R.drawable.rana,
        R.drawable.ayush,
        R.drawable.manu,
        R.drawable.pulkit,
        R.drawable.tanishq,
        R.drawable.shakshay,
        R.drawable.rupali,
        R.drawable.abdulahad,
        R.drawable.jivesh,
        R.drawable.abhay,
        R.drawable.vivek,
        R.drawable.satyam,
        R.drawable.mayan,
        R.drawable.shreyansh,
        R.drawable.harsh
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