package com.cs211d.movietracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Movie::class],
    version=1
)
abstract class MovieDatabase: RoomDatabase() {
    abstract val dao: MovieDao
}