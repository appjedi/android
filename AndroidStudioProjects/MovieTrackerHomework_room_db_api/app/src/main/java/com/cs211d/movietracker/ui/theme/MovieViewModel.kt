package com.cs211d.movietracker.ui.theme
// https://www.youtube.com/watch?v=bOd3wO0uFr8&t=153s

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs211d.movietracker.MovieEvent
import com.cs211d.movietracker.MovieState
import com.cs211d.movietracker.data.Movie
import com.cs211d.movietracker.data.MovieDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MovieViewModel(private val dao: MovieDao
) : ViewModel() {
//    private val _movie
    private val _state = MutableStateFlow(MovieState())

    private val _movies =dao.getMovies()
    var currentMovie:String=""
    var recommendedMovie:String=""
    val state = combine(_state, _movies) { state, movies ->
        state.copy(
            movies = movies,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
        MovieState())

    fun onEvent (event: MovieEvent)
    {
        when(event){
            is MovieEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingMovie = false
                ) }
            }
            is MovieEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingMovie = true
                ) }
            }
            is MovieEvent.SaveMovie ->{
                val movieName=state.value.movieName
                if(movieName.isBlank())
                {
                    return
                }
                val movie = Movie(movieName = movieName)
                viewModelScope.launch { dao.save(movie) }

                _state.update({it.copy(
                    isAddingMovie = false,
                    movieName = "",
                )})
            }
            is MovieEvent.SetMovieNAme->{
                _state.update { it.copy(movieName = event.movieName) }
            }
        }
    }
    fun getCount():Int{return state.value.movies.count()}

    fun getRandomMovie():String {
        val movies = state.value.movies
        val size =movies.size
        val randomNumber:Int = (1..size).random()
        recommendedMovie=movies[randomNumber-1].movieName
        return recommendedMovie
    }


}