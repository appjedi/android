package com.cs211d.movietracker.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository(private val api: ApiService) {

    suspend fun fetchMovies(title:String): Result<List<Movie>> {
        return try {
            val response = api.getMovies(title)
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Server error"))
            }
        } catch (e: Exception) {
            Result.failure(e) // Network error / no internet
        }
    }
}
