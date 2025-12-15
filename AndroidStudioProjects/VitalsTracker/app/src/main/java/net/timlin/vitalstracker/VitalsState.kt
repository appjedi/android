package net.timlin.vitalstracker

import net.timlin.vitalstracker.data.VitalsEntry

data class VitalsState(
    val vitals:List<VitalsEntry> =emptyList(),
    val vitalsEntry: VitalsEntry?=null,
    val isAddingVitals:Boolean=false
)
