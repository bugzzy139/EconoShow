package econoshow.ui

import androidx.lifecycle.ViewModel
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine
import com.example.econoshow.model.MachineType
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * The View Model of the App
 *
 * Controls the state of the app during reconfigurations. Allows the app to redraw while maintaining critical information to improve user experience.
 *
 * @property uiState The StateFlow that can be listened to for different [EconoShowUiState] properties
 */
class EconoShowViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        EconoShowUiState(
            currentMachineType = LocalEconoShowDataProvider.getMachineTypeData().getOrElse(0) {
                LocalEconoShowDataProvider.defaultMachine
            },
            currentMachine = LocalEconoShowDataProvider.getCartonerMachineData().first(),
            currentInformationSubScreenIndex = 0,
            afkTimer = null
        )
    )
    val uiState: StateFlow<EconoShowUiState> = _uiState

    /**
     * Sets the currentMachineType in [EconoShowUiState]
     */
    fun setMachineType(machineType: MachineType) {
        _uiState.update { currentState ->
            currentState.copy(
                currentMachineType = machineType
            )
        }
    }

    /**
     * Sets the currentMachine in [EconoShowUiState]
     */
    fun setMachine(machine: Machine) {
        _uiState.update { currentState ->
            currentState.copy(
                currentMachine = machine
            )
        }
    }

    /**
     * Sets the currentInformationSubScreenIndex in [EconoShowUiState]
     */
    fun setCurrentInformationSubScreenIndex(index: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentInformationSubScreenIndex = index
            )
        }
    }

    /**
     * Sets the afkTimer in [EconoShowUiState]
     */
    fun setAfkTimerJob(afkTimer: Job) {
        _uiState.update { currentState ->
            currentState.copy(
                afkTimer = afkTimer
            )
        }
    }
}

/**
 * The Ui State class for the app
 *
 * Keeps track of different critical information that is maintained through app reconfigurations. Used in the [EconoShowApp].
 *
 * @property currentMachineType The current machine type reference
 * @property currentMachine The current machine reference
 * @property currentInformationSubScreenIndex The current subscreen index for the information (will start at videos if left on videos for a different machine)
 * @property afkTimer Maintains the afk timer coroutine
 */
data class EconoShowUiState(
    val currentMachineType: MachineType,
    val currentMachine: Machine,
    val currentInformationSubScreenIndex: Int,
    val afkTimer: Job?,
)