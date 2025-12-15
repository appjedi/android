package net.timlin.vitalstracker.ui.theme

import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import net.timlin.vitalstracker.model.VitalUIState
import net.timlin.vitalstracker.model.VitalsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.timlin.vitalstracker.VitalsEvent
import net.timlin.vitalstracker.VitalsState
import net.timlin.vitalstracker.data.VitalsEntry
import net.timlin.vitalstracker.network.VitalsRepository
import java.io.File
import kotlin.io.readText
import kotlin.text.split

class VitalsViewModel(private val repository: net.timlin.vitalstracker.data.VitalsRepository) : ViewModel() {
    var currentVitals: VitalsItem
        get() {return currentVitals}
        set(value) {currentVitals=value}

    private val _state = MutableStateFlow(VitalsState())
    private val _vitals =repository.getAllVitals()
    val state = combine(_state, _vitals) { state, vitals ->
        state.copy(
            vitals = vitals,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
        VitalsState())

    fun onEvent (event: VitalsEvent)
    {
        when(event){
            is VitalsEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingVitals = false
                ) }
            }
            is VitalsEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingVitals = true
                ) }
            }
            is VitalsEvent.SaveVitals ->{
                val item=state.value.vitalsEntry
                if(item==null)
                {
                    return
                }

                val entry: VitalsEntry = VitalsEntry(
                    0,
                    item.dateTaken,
                    item.weight,
                    item.pulse,
                    item.bpSystolic,
                    item.bpDiastolic,
                    item.bloodSugar
                )
                viewModelScope.launch { repository.save(entry) }

                _state.update({it.copy(
                    isAddingVitals = false,
                    vitalsEntry = null,
                )})
            }
            is VitalsEvent.SetVitals->{
                _state.update { it.copy(vitalsEntry = event.vitals) }
            }

            is VitalsEvent.DeleteMovie -> {
                viewModelScope.launch { repository.delete(event.vitals) }

            }
        }
    }
    var vitalsList =  mutableStateListOf<VitalsItem>()
    private val _uiState = MutableStateFlow(VitalUIState())
    val uiState: StateFlow<VitalUIState> = _uiState.asStateFlow()
    fun getCurrent():VitalsItem{return currentVitals}

    fun setList(ml:List<VitalsItem>)
    {
        vitalsList= ml as SnapshotStateList<VitalsItem>
    }
    fun addVitals(item: VitalsItem?): Boolean {
        if (item ==null)
        {
            return false;
        }
        val previousEntree = _uiState.value.vitalsItem
        vitalsList.add(item)
        val entry: VitalsEntry = VitalsEntry(
            0,
            item.dateTaken,
            item.weight,
            item.pulse,
            item.bpSystolic,
            item.bpDiastolic,
            item.bloodSugar
        )

        //repository.save(entry)
        return true
        //updateItem(entree, previousEntree)
    }
    //Users/roberttimlin/Documents/GitHub/clients/CCSF/CS211D/AndroidStudioProjects/MovieTrackerHomework

    fun getList():List<VitalsItem> {return vitalsList}


}