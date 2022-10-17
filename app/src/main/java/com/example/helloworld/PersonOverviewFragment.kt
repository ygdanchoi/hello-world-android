package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_PERSON = "PersonOverviewFragment.ARG_PERSON"

class PersonOverviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val person = arguments!!.getParcelable<Person>(ARG_PERSON)!!

        val nameTextView: TextView = view.findViewById(R.id.textview_name)
        val ageTextView: TextView = view.findViewById(R.id.textview_age)
        val weightTextView: TextView = view.findViewById(R.id.textview_weight)

        nameTextView.text = person.name
        ageTextView.text = "${person.age} years old"
        weightTextView.text = "${person.weight} lb"
    }

    companion object {
        @JvmStatic
        fun newInstance(person: Person) =
            PersonOverviewFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PERSON, person)
                }
            }
    }
}