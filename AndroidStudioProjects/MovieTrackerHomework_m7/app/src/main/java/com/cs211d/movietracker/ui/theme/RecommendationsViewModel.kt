package com.cs211d.movietracker.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.cs211d.movietracker.model.MovieUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendationsViewModel : ViewModel() {
    var menuChoice:Int=0
    private val _uiState = MutableStateFlow(MovieUIState())
    val uiState: StateFlow<MovieUIState> = _uiState.asStateFlow()
    var currentMovie:String=""
    var movieList =  mutableStateListOf<String>()

    fun setCurrentMovie(movie:String):Boolean
    {
        if(movie.isEmpty())
        {
            return true
        }
        currentMovie=movie
        return false
    }

    fun updateEntree(movie: String): Boolean {
        if(movie.isEmpty())
        {
            return false
        }
        val previousEntree = _uiState.value.movie
        movieList.add(movie)
        return true
        //updateItem(entree, previousEntree)
    }

    fun getList():List<String> {return movieList}
}