package com.example.winterschool.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.winterschool.R

class RecyclerViewEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ex)

        val items = mutableListOf<String>()
        items.add("a")
        items.add("b")
        items.add("c")

        val rv = findViewById<RecyclerView>(R.id.rv)
        val adapter = RvAdapter(items)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object: RvAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}