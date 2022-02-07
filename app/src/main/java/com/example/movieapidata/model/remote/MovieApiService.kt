package com.example.movieapidata.model.remote

import com.example.movieapidata.model.response.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    companion object {
        const val BASE_URL = "http://www.omdbapi.com/?apikey=9b3ec750"
    }

    @GET("/s")
    suspend fun getMovie(
        @Query("search") search: String
    ): Movie
}