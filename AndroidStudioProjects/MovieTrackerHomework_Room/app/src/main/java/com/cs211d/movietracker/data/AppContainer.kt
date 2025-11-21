package com.cs211d.movietracker.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val moviesRepository: MoviesRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [MoviesRepository]
     */
    override val moviesRepository: MoviesRepository by lazy {
        OfflineMoviesRepository(MovieDatabase.getDatabase(context).itemDao())
    }
}