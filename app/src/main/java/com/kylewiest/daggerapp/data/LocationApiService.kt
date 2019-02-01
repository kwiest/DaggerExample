package com.kylewiest.daggerapp.data

import android.util.Log
import com.kylewiest.daggerapp.Location

class LocationApiService(private val httpClient: HttpClient) {
    private val TAG: String = "BLUEBOTTLE_LOCATION_API_SERVICE"

    fun lookUpValue(locationName: String): Location {
        Log.d(TAG, "Searching for $locationName via API.")
        httpClient.makeRequest()
        return Location(locationName)
    }
}