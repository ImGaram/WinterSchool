package com.example.winterschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.example.winterschool.listView.ListViewAdapter
import com.example.winterschool.listView.ListViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_item = mutableListOf<ListViewModel>()
        list_item.add(ListViewModel("a", "b"))
        list_item.add(ListViewModel("c", "d"))
        list_item.add(ListViewModel("e", "f"))

        val listview = findViewById<ListView>(R.id.main_listview)
        val adapter = ListViewAdapter(list_item)

        listview.adapter = adapter  // 연결
    }

    private var isDone: Boolean = false
    override fun onBackPressed() {
        super.onBackPressed()
        if (isDone == true) {
            finish()
        }

        isDone = true
        Toast.makeText(this, "종료하려면 더블클릭", Toast.LENGTH_SHORT).show()
        Log.d("mainactivity","back button")

        // 2초 딜레이
        Handler().postDelayed(Runnable {
            isDone = false
        }, 2000)
    }
}