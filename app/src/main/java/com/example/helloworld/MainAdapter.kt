package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var names = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }

    fun updateNames(names: List<String>) {
        this.names = names
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.name)

        fun bind(name: String) {
            nameView.text = name
        }
    }
}