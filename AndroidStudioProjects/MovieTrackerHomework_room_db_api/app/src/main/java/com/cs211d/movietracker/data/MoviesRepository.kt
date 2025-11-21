package com.cs211d.movietracker.data

import com.cs211d.movietracker.model.MovieAPI
import com.cs211d.movietracker.network.MoviesAPIService

interface MoviesRepository {
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getMovies(title:String): List<MovieAPI>
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */

class NetworkMoviesRepository(
    private val movieApiService: MoviesAPIService
) : MoviesRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getMovies(title:String): List<MovieAPI> = movieApiService.getMovie(title)

}