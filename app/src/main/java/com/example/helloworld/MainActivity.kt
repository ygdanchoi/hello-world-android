package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gsonConverterFactory = GsonConverterFactory.create()
        val retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(gsonConverterFactory).build()
        val mainService = retrofit.create(MainService::class.java)

        val mainAdapter = MainAdapter().apply { updateNames(listOf("loading...")) }

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }

        Thread {
            mainService.getPeople().execute().body()?.map { it.name }?.let {
                runOnUiThread { mainAdapter.updateNames(it) }
            }
        }.start()
    }
}