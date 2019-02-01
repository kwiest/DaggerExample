package com.kylewiest.daggerapp.data

import com.kylewiest.daggerapp.Location
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService,
    private val locationDatabaseAdapter: LocationDatabaseAdapter
) {

    fun findLocation(locationName: String): Location {
        val location = locationApiService.lookUpValue(locationName)
        locationDatabaseAdapter.saveLocation(location)

        return location
    }
}