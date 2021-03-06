package com.desafiomobile2you.features.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiomobile2you.adapter.SimilarAdapter
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {


            viewModel = ViewModelProvider(it)[HomeViewModel::class.java]

            viewModel.command = MutableLiveData()

            viewModel.getSimilarMovies()


            setupObeservables()

        }
    }

    private fun setupObeservables() {

        viewModel.onSuccessSimilar.observe(viewLifecycleOwner, {
            it.let { similarList ->
                val similarAdapter = SimilarAdapter(
                    similarList = similarList
                ) { movie ->
                    viewModel.getMovieDetailsById(movie.id)
                }
                binding?.let {
                    with(it) {
                        rvHomeSimilar.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = similarAdapter
                        }
                    }
                }

            }
        })

        viewModel.onErrorSimilar.observe(viewLifecycleOwner, {
            it
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}