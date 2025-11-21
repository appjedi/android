package com.cs211d.movietracker.model

import com.cs211d.movietracker.data.Movie

data class MovieUIState(
    // Entree Selection
    val movie: Movie? = null,
)