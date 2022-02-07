package com.example.movieapidata.view

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movieapidata.databinding.FragmentInputBinding
import com.example.movieapidata.viewmodel.MoviesViewModel

class InputFragment : Fragment() {

//    Local instances of binding to communicate with corresponding XML
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

//    First method called when fragment comes into view and inflates view along with binding to right XML
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentInputBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

//    After view is completed can call upon certain methods post load
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

//    Sets a way for an action to take place when button is pressed
//    Which passes data from search EditView to ApiCall
    private fun initObservers() {
        binding.btnSearchSubmit.setOnClickListener { view ->
            val search = binding.search.text.toString()
            val action = InputFragmentDirections.actionInputFragmentToMoviesFragment(search)
            view.findNavController().navigate(action)
        }
    }

//    When view is no longer in use cleans up binding
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}