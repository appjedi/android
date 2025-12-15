package net.timlin.vitalstracker.network

class VitalsRepository (private val api: ApiService){
    suspend fun fetchMovies(title:String): Result<List<VitalsRow>> {
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
}