package com.cs211d.movietracker.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movies")
    suspend fun getMovies(title:String): Response<List<Movie>>
}
