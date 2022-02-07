package com.example.movieapidata.model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.create

class RetrofitInstance {

//    Instantiates the retrofit object
    private val retrofit = Retrofit.Builder().baseUrl(MovieApiService.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create()).build()

//    Creates a url getter service from retrofit instance to be used outside of class
    val urlService: MovieApiService by lazy { retrofit.create() }
}
