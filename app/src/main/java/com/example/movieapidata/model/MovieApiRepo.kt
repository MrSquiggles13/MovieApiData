package com.example.movieapidata.model

import com.example.movieapidata.model.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieApiRepo {

    private val urlService by lazy { RetrofitInstance().urlService }

    suspend fun searchMovies(search: String) = withContext(Dispatchers.IO) {
        urlService.getMovie(search)
    }

}