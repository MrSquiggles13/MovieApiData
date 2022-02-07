package com.example.movieapidata.model.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val Title: String,
    val Plot: String,
    val Poster: String
)