package com.app.githubclient.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
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
import com.app.githubclient.util.Constant.Companion.QUERY_PAGE_SIZE
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

    var currentQuery = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                Toast.makeText(requireContext(), "Submitted", Toast.LENGTH_LONG).show()
                currentQuery = query
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
                        adapter?.differ?.submitList(itemResponse.items.toList())
                        val totalPages = itemResponse.totalCount / QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.pageNo.toLong() == totalPages
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
        isLoading = true
    }

    private fun hideProgressBar() {
        binding?.homeProgressBar?.visibility = View.INVISIBLE
        isLoading = false
    }

    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount

            val isNotAtBeginning = firstVisibleItemPosition >= 0
            val isTotalMoreThanVisible = totalItemCount >= QUERY_PAGE_SIZE

            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning &&
                    isTotalMoreThanVisible && isScrolling

            if (shouldPaginate){
                viewModel.getRepositories(currentQuery)
                isScrolling = false
            } else {
                recyclerView.setPadding(0,0,0,0)
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }

    private fun setUpRecyclerview() {
        recyclerView = binding?.homeRecyclerview

        adapter = RecyclerviewItemAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.addOnScrollListener(this@HomeFragment.scrollListener)

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