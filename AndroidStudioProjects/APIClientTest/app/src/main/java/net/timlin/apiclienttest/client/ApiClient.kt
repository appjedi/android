package net.timlin.apiclienttest.client

import net.timlin.apiclienttest.ApiService
import retrofit2.Retrofit

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}

class MoshiConverterFactory(factory: Any) {

}
