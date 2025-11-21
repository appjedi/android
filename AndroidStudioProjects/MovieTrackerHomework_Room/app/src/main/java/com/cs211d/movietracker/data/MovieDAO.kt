package com.cs211d.movietracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {
    @Query("SELECT * from Movies ORDER BY movie ASC")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("SELECT * from Movies WHERE id = :id")
    fun getMovie(id: Int): Flow<Movie>

    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database Room ignores the conflict.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Movie)

    @Update
    suspend fun update(item: Movie)

    @Delete
    suspend fun delete(item: Movie)
}