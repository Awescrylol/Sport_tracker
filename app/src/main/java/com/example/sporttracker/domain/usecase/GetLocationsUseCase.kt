package com.example.sporttracker.domain.usecase

import android.location.Location
import com.example.sporttracker.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
) {

    operator fun invoke(): Flow<Location> =
        locationRepository.getLocations()
}