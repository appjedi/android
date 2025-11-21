/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import com.example.inventory.data.Movie
import com.example.inventory.data.MoviesRepository

/**
 * ViewModel to validate and insert items in the Room database.
 */
class MovieViewModel(private val movieRepository: MoviesRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var movieUiState by mutableStateOf(MovieUIState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(movieDetails: MovieDetails) {
        movieUiState =
            MovieUIState(movieDetails = movieDetails, isEntryValid = validateInput(movieDetails))
    }

    /**
     * Inserts an [Item] in the Room database
     */
    suspend fun saveItem() {
        if (validateInput()) {
            movieRepository.insertMovie(movieUiState.movieDetails.toMovie())
            //itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: MovieDetails = movieUiState.movieDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
data class MovieUIState(
    val movieDetails: MovieDetails = MovieDetails(),
    val isEntryValid: Boolean = false
)

data class MovieDetails(
    val id: Int = 0,
    val name: String = "",

)

/**
 * Extension function to convert [ItemUiState] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun MovieDetails.toMovie(): Movie = Movie(
    id = id,
    name = name
)


/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Item.toMovieUiState(isEntryValid: Boolean = false): MovieUIState = MovieUIState(
    movieDetails = this.toMovieDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Item.toMovieDetails(): MovieDetails = MovieDetails(
    id = id,
    name = name
)
