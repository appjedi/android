package net.timlin.vitalstracker.network

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.squareup.moshi.Moshi
import retrofit2.converter.moshi.MoshiConverterFactory
object RetrofitClient {

    //private val BASE_URL:String = "https://www.omdbapi.com/?apikey=7cfe23df&t="
    //private val BASE_URL:String = "http://10.0.2.2:8080/"
    private val LOCAL_URL:String = "http://10.0.2.2:8080/"

    private val BASE_URL:String = "https://timlin.org/"
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val locatService = Retrofit.Builder()
        .baseUrl(LOCAL_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build().create(ApiService::class.java)
    val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build().create(ApiService::class.java)

}
