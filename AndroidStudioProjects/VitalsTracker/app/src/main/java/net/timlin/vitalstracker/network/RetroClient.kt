package net.timlin.vitalstracker.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //private val BASE_URL:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="
    private val BASE_URL:String = "http://127.0.0.1/:3001/api/vitals/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
