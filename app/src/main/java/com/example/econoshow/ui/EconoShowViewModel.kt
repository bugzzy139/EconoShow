package com.example.econoshow.ui

import androidx.lifecycle.ViewModel
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.model.Machine
import com.example.econoshow.model.MachineType
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

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

    fun setMachineType(machineType: MachineType) {
        _uiState.update { currentState ->
            currentState.copy(
                currentMachineType = machineType
            )
        }
    }

    fun setMachine(machine: Machine) {
        _uiState.update { currentState ->
            currentState.copy(
                currentMachine = machine
            )
        }
    }

    fun setCurrentInformationSubScreenIndex(index: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentInformationSubScreenIndex = index
            )
        }
    }

    fun setAfkTimerJob(afkTimer: Job) {
        _uiState.update { currentState ->
            currentState.copy(
                afkTimer = afkTimer
            )
        }
    }
}

data class EconoShowUiState(
    val currentMachineType: MachineType,
    val currentMachine: Machine,
    val currentInformationSubScreenIndex: Int,
    val afkTimer: Job?,
)