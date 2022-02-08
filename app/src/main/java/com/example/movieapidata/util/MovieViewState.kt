package com.example.movieapidata.util

import androidx.constraintlayout.motion.utils.ViewState
import com.example.movieapidata.model.response.Movie

sealed class MovieViewState {

//    Create a flag of when the data is loading
    object Loading : ViewState()
//    When data returns an error
    data class Error(val exception: String) : ViewState()
//    When data returns success and passes the info along
    data class Success(val movies: List<Movie>): ViewState()
}