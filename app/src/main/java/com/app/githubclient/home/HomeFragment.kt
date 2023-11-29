package com.app.githubclient.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.githubclient.R
import com.app.githubclient.databinding.FragmentHomeBinding
import com.app.githubclient.network.GitApiInstance
import com.app.githubclient.network.GitApiInterface
import kotlinx.coroutines.launch


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
        performSearch()

        recyclerView = binding?.homeRecyclerview
        val layoutManager: RecyclerView.LayoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
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

    private fun searchRepositories(query: String) {
        lifecycleScope.launch {
            try {
                val response = GitApiInstance.gitHubApiService.searchRepositories("java")
                val repositories = response.items

                Toast.makeText(requireContext(), "hello ${repositories.size}", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "hello error ${e}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performSearch() {
        val query = "your_search_query"
        searchRepositories(query)
    }
}