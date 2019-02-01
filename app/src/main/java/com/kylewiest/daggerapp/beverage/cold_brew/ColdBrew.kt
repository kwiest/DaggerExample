package com.kylewiest.daggerapp.beverage.cold_brew

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.kylewiest.daggerapp.Location
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.Session
import com.kylewiest.daggerapp.data.LocationRepository
import javax.inject.Inject

class ColdBrew @Inject constructor(
    private val appContext: Context,
    private val locationRepository: LocationRepository,
    private val session: Session
) : Beverage(BeverageType.ColdBrew) {

    lateinit var location: Location

    override fun brew() {
        location = locationRepository.findLocation(session.preferredLocationName)
        Log.d(TAG, "Brewing delicious, refreshing cold brew")
        displayInAppNotification()
    }

    private fun displayInAppNotification() {
        Toast.makeText(appContext, notificationText(), Toast.LENGTH_LONG)
            .show()
    }

    private fun notificationText() = "Yor Cold Brew has been ordered at ${location.name}"
}