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

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

class OfflineMoviesRepository(private val movieDao: MovieDao) : MoviesRepository  {
    override fun getAllMoviesStream(): Flow<List<Movie>> = movieDao.getAllMovies()

    override fun getMovieStream(id: Int): Flow<Movie?> = movieDao.getMovie(id)

    override suspend fun insertMovie(item: Movie) = movieDao.insert(item)

    override suspend fun deleteMovie(item: Movie) = movieDao.delete(item)

    override suspend fun updateMovie(item: Movie) = movieDao.update(item)
}
