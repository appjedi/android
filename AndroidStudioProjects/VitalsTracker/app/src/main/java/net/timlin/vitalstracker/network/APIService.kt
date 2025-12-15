package net.timlin.vitalstracker.network


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("vitals")
    suspend fun getVitals(): Response<List<VitalsRow>>
    @POST(value="vitals")
    suspend fun postVitals(vital: VitalsRow):Response<VitalsRow>

}
