package com.example.movieapidata.viewmodel

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapidata.util.MovieViewState

class MoviesViewModel: ViewModel() {

    private val _viewState = MutableLiveData<ViewState>(MovieViewState.Loading)
    val viewState: LiveData<ViewState> get() = _viewState
}