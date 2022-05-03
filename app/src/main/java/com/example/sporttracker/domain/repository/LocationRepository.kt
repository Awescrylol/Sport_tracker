package com.example.sporttracker.domain.repository

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getLocations(): Flow<Location>
}