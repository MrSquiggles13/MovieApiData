package com.example.movieapidata.model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.create

class RetrofitInstance {

    private val retrofit = Retrofit.Builder().baseUrl(MovieApiService.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create()).build()

    val urlService: MovieApiService by lazy { retrofit.create() }
}
