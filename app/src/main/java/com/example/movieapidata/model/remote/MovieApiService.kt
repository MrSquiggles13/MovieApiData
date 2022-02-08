package com.example.movieapidata.model.remote

import com.example.movieapidata.model.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

//    This is our starting URL for queries
    companion object {
        const val BASE_URL = "http://www.omdbapi.com"
    }


//    Utilizing retrofit get decorator to query the api with a set parameter
    @GET("/?apikey=9b3ec750&")
    suspend fun getMovie(
        @Query("s") search: String
    ): Response
}