package com.cs211d.vitalstracker.model

import android.annotation.SuppressLint

class VitalsItem
{
    var dateTaken: String=""
    var weight:Float=0f
    var pulse:Int=0
    var bpSystolic: Int=0 // TOP
    var bpDiastolic: Int=0 // BOTTOM
    var bloodSugar: Float=0f

    @SuppressLint("DefaultLocale")
    override fun toString():String
    {
        return String.format("%s - %.2f", dateTaken,weight)
    }
    // VitalsItem("",0,0,0,0,0)
}
