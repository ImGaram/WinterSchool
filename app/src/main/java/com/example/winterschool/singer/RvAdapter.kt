package com.example.winterschool.singer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winterschool.R

class RvAdapter(val items: MutableList<String>): RecyclerView.Adapter<RvAdapter.ViewHoder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_trot, parent, false)

        return ViewHoder(view)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHoder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHoder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: String) {
            val rv_text = itemView.findViewById<TextView>(R.id.rv_text_id)
            rv_text.text = item
        }
    }
}