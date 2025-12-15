package net.timlin.vitalstracker.network

import net.timlin.vitalstracker.model.VitalsItem

class VitalsRepository (private val api: ApiService){
    suspend fun fetchVitals(title:String): Result<List<VitalsRow>> {
        return try {
            val response = api.getVitals()
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Server error"))
            }
        } catch (e: Exception) {
            Result.failure(e) // Network error / no internet
        }
    }
    suspend fun postVitals(vital: VitalsRow): Result<VitalsRow?> {
        return try {
            val response = api.postVitals(vital)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(Exception("Server error"))
            }
        } catch (e: Exception) {
            Result.failure(e) // Network error / no internet
        }
    }
}