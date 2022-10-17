package com.example.helloworld

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var people = listOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(people[position])
    }

    override fun getItemCount(): Int {
        return people.size
    }

    fun updateNames(people: List<Person>) {
        this.people = people
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.name)

        fun bind(person: Person) {
            nameView.text = person.name

            itemView.setOnClickListener {
                val intent = Intent(it.context, PersonActivity::class.java).apply {
                    putExtra(PersonActivity.EXTRA_PERSON, person)
                }
                it.context.startActivity(intent)
            }
        }
    }
}