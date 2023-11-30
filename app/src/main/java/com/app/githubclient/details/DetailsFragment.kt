package com.app.githubclient.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.app.githubclient.R
import com.app.githubclient.databinding.FragmentDetailsBinding
import com.app.githubclient.databinding.FragmentHomeBinding
import com.app.githubclient.home.HomeViewModel
import com.app.githubclient.home.HomeViewModelProviderFactory
import com.app.githubclient.repository.Repository
import com.app.githubclient.room.ItemDatabase
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {
    private val TAG = "DetailsFragment"
    private var binding: FragmentDetailsBinding? = null
    private lateinit var viewModel: DetailsViewModel

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository(ItemDatabase(requireContext()))
        val detailsModelProviderFactory = DetailsModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, detailsModelProviderFactory)[DetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater,
            R.layout.fragment_details, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repo = args.repo

        Glide.with(this).load(repo.owner?.avatarUrl).into(binding!!.image)

        binding?.repoName?.text = args.repo.name
        binding?.description?.text = args.repo.description



    }

}