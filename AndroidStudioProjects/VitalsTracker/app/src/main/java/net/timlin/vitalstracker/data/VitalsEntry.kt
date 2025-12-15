package net.timlin.vitalstracker.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VitalsEntry(
    @PrimaryKey(autoGenerate=true)
    val id:Int?=null,
    var dateTaken: String,
    var weight:Float,
    var pulse:Int,
    var bpSystolic: Int, // TOP
    var bpDiastolic: Int,// BOTTOM
    var bloodSugar: Float
)
