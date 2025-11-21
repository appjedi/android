package com.cs211d.movietracker

import com.cs211d.movietracker.data.Movie

sealed interface MovieEvent {
    object SaveMovie: MovieEvent
    data class SetMovieName(val movieName:String):MovieEvent
    data class DeleteMovie(val movie: Movie):MovieEvent

    object ShowDialog:MovieEvent
    object HideDialog:MovieEvent


}