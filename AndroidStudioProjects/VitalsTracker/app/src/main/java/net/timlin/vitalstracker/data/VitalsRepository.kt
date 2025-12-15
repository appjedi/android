package net.timlin.vitalstracker.data

import kotlinx.coroutines.flow.Flow

class MovieRepository(private val dao: VitalsDAO) {
    suspend fun save(entry: VitalsEntry)=  dao.save(entry)

    suspend fun delete(entry:VitalsEntry)=dao.delete(entry)

    fun getMovies(): Flow<List<VitalsEntry>> = dao.getAllVitals()

}