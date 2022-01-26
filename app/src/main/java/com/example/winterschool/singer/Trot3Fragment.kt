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

class Trot3Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trot3, container, false)

        val items = mutableListOf<String>()
        items.add("피어나")
        items.add("진실 혹은 대답")
        items.add("우리 사랑하게 됐어요")
        items.add("피어나")
        items.add("진실 혹은 대답")
        items.add("우리 사랑하게 됐어요")
        items.add("피어나")
        items.add("진실 혹은 대답")
        items.add("우리 사랑하게 됐어요")
        items.add("피어나")
        items.add("진실 혹은 대답")
        items.add("우리 사랑하게 됐어요")
        items.add("피어나")
        items.add("진실 혹은 대답")
        items.add("우리 사랑하게 됐어요")

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_sing)
        val adapter = RvAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image1).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot3Fragment_to_trot1Fragment)
        }

        view.findViewById<ImageView>(R.id.image2).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot3Fragment_to_trot2Fragment)
        }

        return view
    }
}