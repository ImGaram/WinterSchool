package com.example.winterschool.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.winterschool.R
import com.example.winterschool.listView.ListViewModel2
import com.example.winterschool.listView.ListViewAdapter2

class ListView2Ex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2_ex)

//        val listItem = mutableListOf<String>()
//        listItem.add("A")
//        listItem.add("B")
//        listItem.add("C")

        val listItem2 = mutableListOf<ListViewModel2>()
        listItem2.add(ListViewModel2("a","b"))
        listItem2.add(ListViewModel2("c","d"))
        listItem2.add(ListViewModel2("e","f"))

        val listview = findViewById<ListView>(R.id.main_listview2)

        val adapter = ListViewAdapter2(listItem2)
        listview.adapter = adapter

        listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, listItem2[position].text1, Toast.LENGTH_SHORT).show()
        }
    }
}