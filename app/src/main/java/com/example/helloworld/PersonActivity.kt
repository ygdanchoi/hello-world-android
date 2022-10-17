package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PersonActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var ageTextView: TextView
    lateinit var weightTextView: TextView

    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        nameTextView = findViewById(R.id.textview_name)
        ageTextView = findViewById(R.id.textview_age)
        weightTextView = findViewById(R.id.textview_weight)

        person = intent.getParcelableExtra(EXTRA_PERSON)!!
        nameTextView.text = person.name
        ageTextView.text = "${person.age} years old"
        weightTextView.text = "${person.weight} lbs"
    }

    companion object {
        const val EXTRA_PERSON = "PersonActivity.EXTRA_PERSON"
    }
}