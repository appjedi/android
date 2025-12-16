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
){
    override fun toString():String
    {
        return String.format("%s - %.2f", this.dateTaken,this.weight)
    }
}
