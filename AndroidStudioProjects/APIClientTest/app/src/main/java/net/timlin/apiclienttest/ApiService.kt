package net.timlin.apiclienttest


import net.timlin.apiclienttest.data.SearchResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun searchItems(
        @Query("query") query: String,
        @Query("page") page: Int
    ): SearchResponse
}
