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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.githubclient.R
import com.app.githubclient.databinding.FragmentHomeBinding
import com.app.githubclient.network.GitApiInstance
import com.app.githubclient.network.GitApiInterface
import com.app.githubclient.repository.Repository
import com.app.githubclient.room.ItemDatabase
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerviewItemAdapter? = null

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository(ItemDatabase(requireContext()))
        val viewModelProviderFactory = HomeViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                Toast.makeText(requireContext(), "Search done", Toast.LENGTH_LONG).show()
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(requireContext(), "Typing...", Toast.LENGTH_LONG).show()
                return false
            }
        })

        recyclerView = binding?.homeRecyclerview
        val layoutManager: RecyclerView.LayoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.layoutManager = layoutManager

        adapter = RecyclerviewItemAdapter()
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
                val response = GitApiInstance.gitHubApiService.searchRepositories(query)

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "hello error $e", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performSearch(query: String) {
        searchRepositories(query)
    }
}