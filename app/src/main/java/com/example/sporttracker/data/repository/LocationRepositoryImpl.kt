package com.example.sporttracker.data.repository

import android.location.Location
import com.example.sporttracker.data.datasource.LocationDataSource
import com.example.sporttracker.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
) : LocationRepository {

    override fun getLocations(): Flow<Location> =
        locationDataSource.getLocations()
}