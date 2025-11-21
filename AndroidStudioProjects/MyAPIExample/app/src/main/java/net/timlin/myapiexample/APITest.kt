package net.timlin.myapiexample

import android.os.Build
import androidx.annotation.RequiresApi
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
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
        val url:String = "https://timlin.org/api/registration/"+title
        val url2:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="+title
        print (url2)
        val response: HttpResponse = client.get(url2) ;
/*
        {
           // parameter("id", userId) // Add query parameter
        }
        */

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

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    runBlocking {
        val reg = fetchMovie("star+wars")
        if (reg != null) {
             println("Fetched user: $reg")
        }
    }
}