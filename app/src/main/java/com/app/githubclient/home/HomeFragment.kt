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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.githubclient.R
import com.app.githubclient.databinding.FragmentHomeBinding
import com.app.githubclient.repository.Repository
import com.app.githubclient.room.ItemDatabase
import com.app.githubclient.util.Resource
import retrofit2.Response

class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
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

                Toast.makeText(requireContext(), "Submitted", Toast.LENGTH_LONG).show()
                viewModel.getRepositories(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        hideProgressBar()
        setUpRecyclerview()

        viewModel.searchRepositories.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    Log.e(TAG, "Success")
                    hideProgressBar()
                    response.data?.let { itemResponse ->
                        adapter?.differ?.submitList(itemResponse.items)
                    }
                }

                is Resource.Error -> {
                    showProgressBar()
                    response.message?.let {
                        Log.e(TAG, "Error messages ${response.message}")
                    }
                }

                is Resource.Loading -> {
                    Log.e(TAG, "Loading...")
                    showProgressBar()
                }

                else -> {Log.e(TAG, "something went wrong...")}
            }
        })

        binding
    }

    private fun showProgressBar() {
        binding?.homeProgressBar?.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding?.homeProgressBar?.visibility = View.INVISIBLE
    }

    private fun setUpRecyclerview() {
        recyclerView = binding?.homeRecyclerview

        adapter = RecyclerviewItemAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())

        adapter?.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("repo", it)
            }

            findNavController().navigate(
                R.id.action_homeFragment_to_detailsFragment,
                bundle
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )
        return binding!!.root
    }
}