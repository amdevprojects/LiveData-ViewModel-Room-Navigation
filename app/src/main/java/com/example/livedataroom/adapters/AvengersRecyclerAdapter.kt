package com.example.livedataroom.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedataroom.R
import com.example.livedataroom.db.Avengers
import kotlinx.android.synthetic.main.item_avenger.view.*

class AvengersRecyclerAdapter(private val avengers: MutableList<Avengers>): RecyclerView.Adapter<AvengersRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_avenger, parent, false))
    }

    override fun getItemCount(): Int {
        return avengers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = avengers[position]
        holder.name.text = item.name
        holder.desc.text = item.desc
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.name
        val desc = itemView.desc
    }
}