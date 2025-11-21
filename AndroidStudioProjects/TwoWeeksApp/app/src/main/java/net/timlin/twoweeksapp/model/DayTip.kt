/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.timlin.twoweeksapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.timlin.twoweeksapp.VitalsApp
import net.timlin.twoweeksapp.data.UserPreferencesRepository
import net.timlin.twoweeksapp.R
/**
 * [DayTip] is the data class to represent the Affirmation text and imageResourceId
 */
class TwoWeekViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    // UI states access for various [DessertReleaseUiState]
    val uiState: StateFlow<TwoWeeksUiState> =
        userPreferencesRepository.isLinearLayout.map { isLinearLayout ->
            TwoWeeksUiState(isLinearLayout)
        }.stateIn(
            scope = viewModelScope,
            // Flow is set to emits value for when app is on the foreground
            // 5 seconds stop delay is added to ensure it flows continuously
            // for cases such as configuration change
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = runBlocking {
                TwoWeeksUiState(
                    isLinearLayout = userPreferencesRepository.isLinearLayout.first()
                )
            }
        )

    /*
     * [selectLayout] change the layout and icons accordingly and
     * save the selection in DataStore through [userPreferencesRepository]
     */
    fun selectLayout(isLinearLayout: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveLayoutPreference(isLinearLayout)
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {

            initializer {
                val application = (this[APPLICATION_KEY] as VitalsApp)
                TwoWeekViewModel(application.userPreferencesRepository)
            }
        }
    }
}
data class DayTip(
    @StringRes val label: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val tips: Int,

)
data class TwoWeeksUiState(
    val isLinearLayout: Boolean = true,
    val toggleContentDescription: Int =
        if (isLinearLayout) R.string.grid_layout_toggle else R.string.linear_layout_toggle,
    val toggleIcon: Int =
        if (isLinearLayout) R.drawable.ic_grid_layout else R.drawable.ic_linear_layout
)

