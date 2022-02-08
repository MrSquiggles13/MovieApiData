package com.example.movieapidata.viewmodel

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.*
import com.example.movieapidata.model.MovieApiRepo
import com.example.movieapidata.util.MovieViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MoviesViewModel(state: SavedStateHandle): ViewModel() {

//    Using safeArgs grab current argument from previous fragment to use in api request
    private val search = state.get<String>("apiSearch")

//    Current state and data that is being held
    private val _viewState = MutableLiveData<ViewState>(MovieViewState.Loading)
    val viewState: LiveData<ViewState> get() = _viewState

//    on IO thread check for search and if there is a hit or not
//    on Hit success from viewstate is enacted
//    on Error error from viewstate is displayed
    fun executeNetworkRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            search?.let { search ->
                val state = try {
                    val response = MovieApiRepo.searchMovies(search)
                    MovieViewState.Success(movies = response.Search)
                } catch(ex: Exception) {
                    MovieViewState.Error(ex.message ?: "Something went wrong")
                }
//                Separate Thread (main) viewstate object is set
                withContext(Dispatchers.Main) {
                    _viewState.value = state
                }
            }
        }
    }
}