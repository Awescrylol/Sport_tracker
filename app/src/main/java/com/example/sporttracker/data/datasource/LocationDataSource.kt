package com.example.sporttracker.data.datasource

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

interface LocationDataSource {

    fun getLocations(): Flow<Location>
}

class LocationDataSourceImpl @Inject constructor(
    private val context: Context
) : LocationDataSource {

    @OptIn(ExperimentalCoroutinesApi::class)
    @SuppressLint("MissingPermission")
    override fun getLocations(): Flow<Location> = callbackFlow {

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationListener = LocationListener { location -> trySend(location) }

        Log.e(
            "GPS_PROVIDER",
            locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER).toString()
        )

        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000,
            0f,
            locationListener
        )
        awaitClose { locationManager.removeUpdates(locationListener) }
    }
}

