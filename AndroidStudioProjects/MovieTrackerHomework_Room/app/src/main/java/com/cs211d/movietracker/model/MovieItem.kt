package com.cs211d.movietracker.model

sealed class MovieItem1(
    open var movieName: String,

){
    data class MovieEntry1(
        override var movieName: String

    ) : MovieItem1(movieName)
}