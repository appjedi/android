package com.cs211d.movietracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert
    suspend fun save(movie:Movie)

    @Query("SELECT * FROM movie")
    fun getMovies(): Flow<List<Movie>>
}