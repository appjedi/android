package net.timlin.vitalstracker

import net.timlin.vitalstracker.data.VitalsEntry

sealed interface VitalsEvent {
    object SaveVitals: VitalsEvent
    data class SetVitals(val vitals: VitalsEntry):VitalsEvent
    data class DeleteMovie(val vitals: VitalsEntry):VitalsEvent

    object ShowDialog:VitalsEvent
    object HideDialog:VitalsEvent

    object GetVitals:VitalsEvent
}