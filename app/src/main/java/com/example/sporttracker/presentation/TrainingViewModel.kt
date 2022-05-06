package com.example.sporttracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sporttracker.util.SingleLiveEvent
import com.google.android.gms.maps.GoogleMap
import javax.inject.Inject

class TrainingViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableLiveData<TrainingScreenState>(TrainingScreenState.Initial)
    val state: LiveData<TrainingScreenState> = _state

    private val _startMapLoadingEvent = SingleLiveEvent<Unit>()
    val startMapLoadingEvent: LiveData<Unit> = _startMapLoadingEvent

    private val _startForegroundServiceEvent = SingleLiveEvent<Unit>()
    val startForegroundServiceEvent: LiveData<Unit> = _startForegroundServiceEvent

    fun loadMap() {
        if (_state.value != TrainingScreenState.Initial) return

        _state.value = TrainingScreenState.Loading

        _startMapLoadingEvent()
    }

    fun handleMap(googleMap: GoogleMap) {
        _state.value = TrainingScreenState.Content(
            googleMap = googleMap,
            trainingStarted = false,
        )
    }

    fun startTraining() {
        val contentState = _state.value as? TrainingScreenState.Content ?: return

        _state.value = contentState.copy(trainingStarted = true)
        _startForegroundServiceEvent()
    }
}