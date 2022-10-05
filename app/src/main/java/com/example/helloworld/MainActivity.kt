package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val names = listOf(
            "anita",
            "bertha",
            "caleb",
            "darcy",
            "emilio",
            "fabian",
            "gustavo",
            "hephaestus",
            "ignacio",
            "juarez",
            "katerina",
            "lennox",
            "maximilian",
            "napoleon",
            "ophelia",
            "paulina",
            "quinn",
            "rasputin",
            "sophocles",
            "tiberius",
            "ursula",
            "valentino",
            "winston",
            "xavier",
            "yolanda",
            "zechariah"
        )
        recyclerView.adapter = MainAdapter(names)
    }
}