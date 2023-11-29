package com.app.githubclient.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.githubclient.R
import com.app.githubclient.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    var recyclerView: RecyclerView? = null
    var adapter: RecyclerviewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(requireContext(), "Search done", Toast.LENGTH_LONG).show()
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(requireContext(), "Typing...", Toast.LENGTH_LONG).show()
                return false
            }
        })

        val dummyList = listOf(
            HomePojo("Item 1"),
            HomePojo("Item 2"),
            HomePojo("Item 3"),
        )

        val layoutManager: RecyclerView.LayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.layoutManager = layoutManager
        adapter = RecyclerviewAdapter(context, dummyList)
        recyclerView?.adapter = adapter

        binding
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
                                R.layout.fragment_home, container, false)
        return binding!!.root
    }
}