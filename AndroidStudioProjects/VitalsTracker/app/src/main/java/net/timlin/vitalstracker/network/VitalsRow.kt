package net.timlin.vitalstracker.network
import kotlinx.serialization.Serializable


@Serializable
data class VitalsRow(
    val id:Int,
                        var dateTaken: String,
                        var weight:Float,
                        var pulse:Int,
                        var bpSystolic: Int, // TOP
                        var bpDiastolic: Int,// BOTTOM
                        var bloodSugar: Float)
