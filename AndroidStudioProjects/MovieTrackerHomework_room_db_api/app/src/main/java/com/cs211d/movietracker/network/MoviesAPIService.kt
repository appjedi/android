package com.cs211d.movietracker.network

import com.cs211d.movietracker.data.Movie
import com.cs211d.movietracker.model.MovieAPI
import kotlinx.serialization.json.Json
import retrofit2.http.GET

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*

interface MoviesAPIService {
    @GET("movies")
    suspend fun getMovie(tile:String): List<MovieAPI>
}
suspend fun fetchMovie(title: String): Movie? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Handle cases where API returns more fields than in your data class
            })
        }
    }

    try {
        val url:String = "https://timlin.org/api/registration/"+title
        val url2:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="+title
        print (url2)
        val response: HttpResponse = client.get(url2) ;


        if (response.status.value == 200) {
            val text:String = response.bodyAsText()
            return response.bodyAsText().let { Json.decodeFromString<Movie>(it) }
        } else {
            println("Error: ${response.status.value} - ${response.bodyAsText()}")
            return null
        }
    } catch (e: Exception) {
        println("Network error: ${e.message}")
        return null
    } finally {
        client.close()
    }
}