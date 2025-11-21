package com.cs211d.movietracker.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cs211d.movietracker.MovieState
import com.cs211d.movietracker.MoviesApplication
import com.cs211d.movietracker.data.MoviesRepository
import com.cs211d.movietracker.model.MovieAPI
import com.cs211d.movietracker.model.MovieUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cs211d.movietracker.data.MovieDao

sealed interface APIUiState {
    data class Success(val movies: List<MovieAPI>) : APIUiState
    object Error : APIUiState
    object Loading : APIUiState
}
class RecommendationsViewModel(private val dao: MovieDao) : ViewModel() {
    var menuChoice:Int=0
    private val _uiState = MutableStateFlow(MovieUIState())
    val uiState: StateFlow<MovieUIState> = _uiState.asStateFlow()
    var currentMovie:String=""
    var recommendedMovie:String=""
    var movieList =  mutableStateListOf<String>()
    var movieUiState: APIUiState by mutableStateOf(APIUiState.Loading)
        private set

    private val _movies =dao.getMovies()

    private val _state = MutableStateFlow(MovieState())
    val state = combine(_state, _movies) { state, movies ->
        state.copy(
            movies = movies,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
        MovieState())

    fun getCount():Int{return state.value.movies.count()}
    fun getRandomMovie():String {
        val movies = state.value.movies
        val size =movies.size
        val randomNumber:Int = (1..size).random()
        recommendedMovie=movies[randomNumber-1].movieName
        return recommendedMovie
    }
    fun getAPIMovie(title:String)
    {



    }


}
