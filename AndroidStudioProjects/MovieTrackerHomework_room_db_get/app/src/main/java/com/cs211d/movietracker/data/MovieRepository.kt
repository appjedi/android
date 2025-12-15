package com.cs211d.movietracker.data

import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun save(movie:Movie)=  movieDao.save(movie)

    suspend fun delete(movie:Movie)=movieDao.delete(movie)

    fun getMovies(): Flow<List<Movie>> = movieDao.getMovies()

}