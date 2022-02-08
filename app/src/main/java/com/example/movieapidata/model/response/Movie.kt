package com.example.movieapidata.model.response

import com.squareup.moshi.JsonClass


// Data classes with json decorators that captures the properties of the request
@JsonClass(generateAdapter = true)
data class Movie(
    val Title: String,
    val Poster: String
)

@JsonClass(generateAdapter = true)
data class Response(
    val Search: List<Movie>
)