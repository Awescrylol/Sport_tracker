package com.example.sporttracker.presentation

import com.google.android.gms.maps.GoogleMap

sealed interface TrainingScreenState {

    object Initial : TrainingScreenState

    object Loading : TrainingScreenState

    data class Content(
        val googleMap: GoogleMap,
        val trainingStarted: Boolean,
    ) : TrainingScreenState
}