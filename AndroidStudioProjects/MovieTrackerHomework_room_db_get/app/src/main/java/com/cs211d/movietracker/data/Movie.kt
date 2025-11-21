package com.cs211d.movietracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate=true)
    val id:Int?=null,
    val movieName: String
)
