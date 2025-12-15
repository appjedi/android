package net.timlin.vitalstracker.data

import kotlinx.coroutines.flow.Flow

class VitalsRepository(private val dao: VitalsDAO) {
    suspend fun save(entry: VitalsEntry)=  dao.save(entry)

    suspend fun delete(entry:VitalsEntry)=dao.delete(entry)

    fun getAllVitals(): Flow<List<VitalsEntry>> = dao.getAllVitals()

}