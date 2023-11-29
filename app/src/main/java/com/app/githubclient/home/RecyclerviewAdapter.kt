package com.app.githubclient.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.githubclient.R

class RecyclerviewAdapter(private val homes: Context?, private val dummyList: List<HomePojo>) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val homeName: TextView = itemView.findViewById(R.id.repoName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentHome = dummyList[position]
        holder.homeName.text = currentHome.name
    }

    override fun getItemCount(): Int {
        return dummyList.size
    }
}
