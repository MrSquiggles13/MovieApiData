package com.example.movieapidata.model.remote

import com.example.movieapidata.model.response.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

//    This is our starting URL for queries
    companion object {
        const val BASE_URL = "http://www.omdbapi.com/?apikey=9b3ec750"
    }


//    Utilizing retrofit get decorator to query the api with a set parameter
    @GET("/s")
    suspend fun getMovie(
        @Query("search") search: String
    ): List<Movie>
}