package com.cs211d.movietracker.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.cs211d.movietracker.model.MovieUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel : ViewModel() {
    var currentMovie:String=""
    var recommendedMovie:String=""

    var movieList =  mutableStateListOf<String>()
    private val _uiState = MutableStateFlow(MovieUIState())
    val uiState: StateFlow<MovieUIState> = _uiState.asStateFlow()

    fun setList(ml:List<String>)
    {
        movieList= ml as SnapshotStateList<String>
    }
    fun setCurrentMovie(movie:String):Boolean
    {
        if(movie.isEmpty())
        {
            return true
        }
        currentMovie=movie
        return false
    }
    //Users/roberttimlin/Documents/GitHub/clients/CCSF/CS211D/AndroidStudioProjects/MovieTrackerHomework
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
    fun getCount():Int {return movieList.size}
    fun getRandomMovie():String {
        val size =movieList.size
        val randomNumber:Int = (1..size).random()
        recommendedMovie=movieList[randomNumber-1]
        return recommendedMovie
    }
    fun getList():List<String> {return movieList}
}