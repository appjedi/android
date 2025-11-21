package net.timlin.vitalstracker.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import net.timlin.vitalstracker.model.VitalUIState
import net.timlin.vitalstracker.model.VitalsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File
import kotlin.io.readText
import kotlin.text.split

class VitalsViewModel : ViewModel() {
    var currentVitals: VitalsItem
        get() {return currentVitals}
        set(value) {currentVitals=value}

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
        return true
        //updateItem(entree, previousEntree)
    }
    //Users/roberttimlin/Documents/GitHub/clients/CCSF/CS211D/AndroidStudioProjects/MovieTrackerHomework

    fun getList():List<VitalsItem> {return vitalsList}

    fun readFile()
    {
        val filePath = "path/to/your/file.txt" // Replace with your file path
        val fileContent: String = File(filePath).readText()
        val contents = fileContent.split("\n")
        for(line:String in contents)
        {
            val item: VitalsItem

            val values=line.split("\t")
            /*
            var vitals =  VitalsItem(
                values[0],
                values[1].toFloat(),
                values[2].toInt(),
                values[3].toInt(),
                values[4].toInt(),
                values[5].toFloat()

            )
*/
        }
    }
}