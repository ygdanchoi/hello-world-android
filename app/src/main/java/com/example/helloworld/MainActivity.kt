package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainAdapter = MainAdapter().apply { updateNames(listOf("loading...")) }

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mainAdapter
        }

        Thread {
            val url = URL("http://10.0.2.2:3000/people")
            val connection = url.openConnection() as HttpURLConnection
            val jsonResponse = connection.inputStream.bufferedReader().readLine()
            val jsonArray = JSONArray(jsonResponse)

            val names = mutableListOf<String>()
            for (i in 0 until jsonArray.length()) {
                val person = jsonArray[i] as JSONObject
                names.add(person.getString("name"))
            }

            runOnUiThread { mainAdapter.updateNames(names) }
        }.start()
    }
}