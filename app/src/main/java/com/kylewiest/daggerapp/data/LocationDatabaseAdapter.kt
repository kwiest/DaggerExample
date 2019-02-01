package com.kylewiest.daggerapp.data

import android.util.Log
import com.kylewiest.daggerapp.Location

class LocationDatabaseAdapter(private val databaseUrl: String) {
    private val TAG: String = "BLUEBOTTLE_DATABASE_CONNECTION"

    fun lookupValue(locationName: String) {
        Log.d(TAG, "Looking up $locationName in database $databaseUrl.")
    }

    fun saveLocation(location: Location) {
        Log.d(TAG, "Saving ${location.name} to local database $databaseUrl.")
    }
}