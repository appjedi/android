package net.timlin.vitalstracker.network


import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("vitals")
    suspend fun getVitals(): Response<List<VitalsRow>>

}
