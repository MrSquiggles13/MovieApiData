package com.example.movieapidata.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapidata.databinding.FragmentMoviesBinding
import com.example.movieapidata.model.response.Movie
import com.example.movieapidata.util.MovieViewState
import com.example.movieapidata.viewmodel.MoviesViewModel

class MoviesFragment: Fragment() {

//    Local instances of binding to communicate with corresponding XML
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

//    View model instance to handle any logic needed
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also {
        _binding = it
        setHasOptionsMenu(true)
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() = with(viewModel) {
        viewState.observe(viewLifecycleOwner) { state ->
            binding.loader.isVisible = state is MovieViewState.Loading
            if(state is MovieViewState.Success) handleSuccess(state.movies)
            if(state is MovieViewState.Error) handleError(state.exception)
        }
    }

    private fun handleSuccess(movies: List<Movie>) {

    }

    private fun handleError(exception: String) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}