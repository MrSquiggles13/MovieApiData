package com.example.movieapidata.model.response

import com.squareup.moshi.JsonClass


// A data class with a json decorator that captures the properties of the request
@JsonClass(generateAdapter = true)
data class Movie(
    val Title: String,
    val Plot: String,
    val Poster: String
)