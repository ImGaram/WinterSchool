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

class Trot2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trot2, container, false)

        val items = mutableListOf<String>()
        items.add("별빛 간은 나의 사랑")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만 믿어요")
        items.add("별빛 간은 나의 사랑")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만 믿어요")
        items.add("별빛 간은 나의 사랑")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만 믿어요")
        items.add("별빛 간은 나의 사랑")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만 믿어요")

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_sing)
        val adapter = RvAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.image1).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot2Fragment_to_trot1Fragment)
        }

        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            view.findNavController().navigate(R.id.action_trot2Fragment_to_trot3Fragment)
        }

        return view
    }
}