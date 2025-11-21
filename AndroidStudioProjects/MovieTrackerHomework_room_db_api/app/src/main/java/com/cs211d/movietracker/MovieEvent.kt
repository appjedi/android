package com.cs211d.movietracker

sealed interface MovieEvent {
    object SaveMovie: MovieEvent
    data class SetMovieNAme(val movieName:String):MovieEvent

    object ShowDialog:MovieEvent
    object HideDialog:MovieEvent


}