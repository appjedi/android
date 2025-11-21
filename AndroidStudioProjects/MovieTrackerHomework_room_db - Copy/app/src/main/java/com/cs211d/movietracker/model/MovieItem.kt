package com.cs211d.movietracker.model

sealed class MovieItem(
    open var movieName: String,

){
    data class MovieEntry(
        override var movieName: String

    ) : MovieItem(movieName)
}