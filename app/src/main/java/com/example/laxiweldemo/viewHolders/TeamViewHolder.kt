package com.example.laxiweldemo.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laxiweldemo.R
import com.example.laxiweldemo.dtos.TeamDTO

class TeamViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_team, parent, false)) {

    private var team_photo: ImageView?=null
    private var team_name: TextView? = null
    private var team_post: TextView? = null
    private var team_email: TextView? = null
    private var team_number: TextView? = null



    init {
        team_photo= itemView.findViewById(R.id.team_photo)
        team_name= itemView.findViewById(R.id.team_name)
        team_post=itemView.findViewById(R.id.team_designation)
        team_email=itemView.findViewById(R.id.team_email)
        team_number=itemView.findViewById(R.id.team_number)

    }

    fun bind(mEvents: TeamDTO) {
        team_photo?.setImageResource(mEvents.teamPhoto)
        team_name?.text=mEvents.teamName
        team_post?.text= mEvents.tealPost
        team_email?.text=mEvents.teamEmail
        team_number?.text=mEvents.teamNumber

    }
}