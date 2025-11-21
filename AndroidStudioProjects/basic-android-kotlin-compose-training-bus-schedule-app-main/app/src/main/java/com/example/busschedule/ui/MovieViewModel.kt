package com.example.busschedule.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.cs211d.movietracker.data.Movie
import com.cs211d.movietracker.data.MovieDAO
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel (private val dao: MovieDAO): ViewModel() {
    var currentMovie:String=""
    var movieList = mutableStateListOf<String>()

    fun getAllMovies(): Flow<List<Movie>> = dao.getAllMovies()
    fun createMovie(movie:String):Boolean
    {
        if(movie.isEmpty())
        {
            return true
        }
       // val m:Movie = Movie(0);
       // m.movie=movie;


        //dao.insert( m)
        return false
    }

    fun updateEntree(movie: String): Boolean {
        if(movie.isEmpty())
        {
            return false
        }
        //val previousEntree = _uiState.value.movie
        movieList.add(movie)
        return true
        //updateItem(entree, previousEntree)
    }

    fun getList():List<String> {return movieList}
}