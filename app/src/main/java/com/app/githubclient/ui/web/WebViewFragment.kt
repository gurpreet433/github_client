package com.app.githubclient.ui.web

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
import com.app.githubclient.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private var binding: FragmentWebViewBinding? = null

    val args: WebViewFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentWebViewBinding>(
            inflater,
            R.layout.fragment_web_view, container, false
        )
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = args.url

        Toast.makeText(requireContext(), url, Toast.LENGTH_LONG).show()

    }
}