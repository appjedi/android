package net.timlin.vitalstracker.network
import kotlinx.serialization.Serializable


@Serializable
data class VitalsRow(
    val id:Long,
                        var dateTaken: String,
                        var weight:Float,
                        var pulse:Int,
                        var bpSystolic: Int, // TOP
                        var bpDiastolic: Int,// BOTTOM
                        var bloodSugar: Float){
    override fun toString():String
    {
        return String.format("%s - %.2f", this.dateTaken,this.weight)
    }
}
