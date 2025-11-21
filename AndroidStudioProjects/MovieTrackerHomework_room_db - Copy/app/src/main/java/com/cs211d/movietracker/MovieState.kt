package com.cs211d.movietracker

import com.cs211d.movietracker.data.Movie

data class MovieState (
    val movies: List<Movie> = emptyList(),
    val movieName:String="",
    val isAddingMovie:Boolean=false
)