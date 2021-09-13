package com.desafiomobile2you.features.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.desafiomobile2you.databinding.FragmentHomeBinding
import com.desafiomobile2you.features.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it)[HomeViewModel::class.java]

            viewModel.getSimilarMovies()

            setupObeservables()

        }
    }

    private fun setupObeservables() {
        activity?.let {
            viewModel.onSuccessSimilar.observe(it,{
                it
            })

            viewModel.onErrorSimilar.observe(it,{
                it
            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}