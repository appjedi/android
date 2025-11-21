package com.cs211d.movietracker.data

import kotlinx.coroutines.flow.Flow

class OfflineMoviesRepository(private val movieeDao: MovieDAO) : MoviesRepository {
    override fun getAllItemsStream(): Flow<List<Movie>> = movieeDao.getAllMovies()

    override fun getItemStream(id: Int): Flow<Movie?> = movieeDao.getMovie(id)

    override suspend fun insertItem(item: Movie) = movieeDao.insert(item)

    override suspend fun deleteItem(item: Movie) = movieeDao.delete(item)

    override suspend fun updateItem(item: Movie) = movieeDao.update(item)
}
