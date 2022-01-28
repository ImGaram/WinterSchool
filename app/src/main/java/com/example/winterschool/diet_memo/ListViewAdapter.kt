package com.example.winterschool.diet_memo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.winterschool.R

class ListViewAdapter(val list: MutableList<dataModel>): BaseAdapter() {
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
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.list_ciew_item_diet, p2, false)
        }

        val date = convertView?.findViewById<TextView>(R.id.listView_date)
        val memo = convertView?.findViewById<TextView>(R.id.listView_memoArea)

        date!!.text = list[p0].date
        memo!!.text = list[p0].memo

        return convertView!!
    }
}