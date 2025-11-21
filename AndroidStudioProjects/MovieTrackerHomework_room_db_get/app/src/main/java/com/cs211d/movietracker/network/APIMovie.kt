package com.cs211d.movietracker.network

import android.os.Build
import androidx.annotation.RequiresApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Rating(
    val Source:String,
    val Value:String
)

@Serializable
data class Movie(
    val Title: String,
    val Year: String,
    val Rated: String,
    val Released: String,
    val Runtime: String,
    val Genre: String,
    val Director: String,
    val Writer: String,
    val Actors: String,
    val Plot: String,
    val Language: String,
    val Country: String,
    val Awards: String,
    val Poster: String,
    val Ratings: List<Rating>,
    val Metascore: String,
    val imdbRating: String,
    val imdbVotes: String,
    val imdbID: String,
    val Type: String,
    val DVD: String,
    val BoxOffice: String,
    val Production: String,
    val Website: String,
    val Response: String,
)
@RequiresApi(Build.VERSION_CODES.O)
suspend fun fetchMovie(title: String): Movie? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Handle cases where API returns more fields than in your data class
            })
        }
    }

    try {
        val url:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="+title.replace(" ","+")
        print (url)
        val response: HttpResponse = client.get(url) ;
        if (response.status.value == 200) {
            val md:Movie= response.bodyAsText().let { Json.decodeFromString<Movie>(it) }
            return md
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
@RequiresApi(Build.VERSION_CODES.O)
fun APIMovie(title:String):Movie? {
    var movie: Movie?=null
    runBlocking {
        movie = fetchMovie(title)
    }
    return movie
}