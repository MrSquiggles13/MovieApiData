package com.example.movieapidata.model

import com.example.movieapidata.model.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieApiRepo {

//    Instantiates the url service to be used to call certain queries with data outside of object
    private val urlService by lazy { RetrofitInstance().urlService }

//    Calls the get movie method from urlService with search param gathered from user
    suspend fun searchMovies(search: String) = withContext(Dispatchers.IO) {
        urlService.getMovie(search)
    }

}