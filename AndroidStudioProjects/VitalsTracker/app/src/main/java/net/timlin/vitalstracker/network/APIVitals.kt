package net.timlin.vitalstracker.network



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


@RequiresApi(Build.VERSION_CODES.O)
suspend fun fetchVitals(): VitalsRow? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Handle cases where API returns more fields than in your data class
            })
        }
    }

    try {
        val url:String="https://timlin.org/api/vitals"
      //  val url:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="+title.replace(" ","+")
        print (url)
        val response: HttpResponse = client.get(url) ;
        if (response.status.value == 200) {
            val md:VitalsRow= response.bodyAsText().let { Json.decodeFromString<VitalsRow>(it) }
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
fun APIMovie(title:String): VitalsRow? {
    var vitals: VitalsRow?=null
    runBlocking {
        vitals = fetchVitals()
    }
    return vitals
}