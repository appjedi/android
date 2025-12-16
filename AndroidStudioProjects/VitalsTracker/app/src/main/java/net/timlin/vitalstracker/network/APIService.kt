package net.timlin.vitalstracker.network


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
// Useful video https://www.youtube.com/watch?v=sLuQbiNa040
interface ApiService {
    @Headers("Content-Type:application/json")

    // header can go in each path as well.
    @GET("api/vitals")
    suspend fun getVitals(): Response<List<VitalsRow>>

    @GET("api/vitals/{id}")
    suspend fun getVital(@Path("id") id:String): Response<List<VitalsRow>>

    @GET("api/vitals")
    suspend fun getVitalsByQuery(@Query("range")range:String): Response<List<VitalsRow>>

    @POST("api/vitals")
    suspend fun postVitals(@Body vital: VitalsRow):Response<VitalsRow>

    @PUT("api/vitals/{id}")
    suspend fun putVitals(@Path("id") id:Int,@Body vital: VitalsRow):Response<VitalsRow>
}
