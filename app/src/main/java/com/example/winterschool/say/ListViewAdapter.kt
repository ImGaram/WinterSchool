package com.example.winterschool.say

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.winterschool.R

class ListViewAdapter(val list: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1
        if (convertView == null) {
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.list_item, p2, false)
        }

        val listViewText = convertView?.findViewById<TextView>(R.id.listViewTextArea)
        listViewText!!.text = list[p0]

        return convertView!!
    }
}