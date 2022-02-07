package com.example.movieapidata.util

import androidx.constraintlayout.motion.utils.ViewState
import com.example.movieapidata.model.response.Movie

sealed class MovieViewState {
    object Loading : ViewState()
    data class Error(val exception: String) : ViewState()
    data class Success(val movies: List<Movie>): ViewState()
}