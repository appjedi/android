package net.timlin.vitalstracker.network

import net.timlin.vitalstracker.model.VitalsItem

class VitalsRepository (){
     suspend fun fetchVitals(title:String): Result<List<VitalsRow>> {
        return try {
            val response = RetrofitClient.apiService.getVitals()
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
            val response = RetrofitClient.apiService.postVitals(vital)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(Exception("Server error"))
            }
        } catch (e: Exception) {
            print(e.toString())
            Result.failure(e) // Network error / no internet
        }
    }
}