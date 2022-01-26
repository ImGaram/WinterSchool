package com.example.winterschool.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winterschool.R

class RvAdapter(val items: MutableList<String>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view:View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        if (itemClick != null) {
            holder.itemView.setOnClickListener {
                itemClick?.onClick(it, position)
            }
        }
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: String) {
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }
    }
}