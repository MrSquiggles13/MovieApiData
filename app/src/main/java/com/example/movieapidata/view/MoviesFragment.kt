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

//    First method called when fragment comes into view and inflates view along with binding to right XML
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also {
        _binding = it
        setHasOptionsMenu(true)
    }.root

//    After view is completed can call upon certain methods post load
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

//    Creates observable data that helps move along data through api call
    private fun initObservers() = with(viewModel) {
        viewState.observe(viewLifecycleOwner) { state ->
            binding.loader.isVisible = state is MovieViewState.Loading
            if(state is MovieViewState.Success) handleSuccess(state.movies)
            if(state is MovieViewState.Error) handleError(state.exception)
        }
    }

//    Called when api returns a success message and loads returned objects
    private fun handleSuccess(movies: List<Movie>) {

    }

//    Called when api fails and gives reason to why with a string
    private fun handleError(exception: String) {

    }

//    When view is no longer in use cleans up binding
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}