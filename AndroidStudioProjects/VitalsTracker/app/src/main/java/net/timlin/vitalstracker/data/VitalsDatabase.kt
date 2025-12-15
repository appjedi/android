package net.timlin.vitalstracker.data


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [VitalsEntry::class],
    version=1
)
abstract class VitalsDatabase: RoomDatabase() {
    abstract val dao: VitalsDAO
}