package net.timlin.vitalstracker.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDAO {
    @Insert
    suspend fun save(item: VitalsEntry)

    @Delete
    suspend fun delete(item: VitalsEntry)

    @Query("SELECT * FROM VitalsEntry")
    fun getAllVitals(): Flow<List<VitalsEntry>>
}