package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_PERSON = "PersonDetailsFragment.ARG_PERSON"

class PersonDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person_details, container, false)
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
            PersonDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PERSON, person)
                }
            }
    }
}