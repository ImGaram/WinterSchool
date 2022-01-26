package com.example.winterschool.singer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.winterschool.R

class Trot1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trot1, container, false)

        val items = mutableListOf<String>()
        items.add("니가 왜 거기서 나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")
        items.add("니가 왜 거기서 나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")
        items.add("니가 왜 거기서 나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")
        items.add("니가 왜 거기서 나와")
        items.add("이불")
        items.add("찐이야")
        items.add("비상")

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_sing)
        val adapter = RvAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot1Fragment_to_trot2Fragment)
        }

        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot1Fragment_to_trot3Fragment)
        }

        return view
    }
}