package com.kylewiest.daggerapp.beverage.cold_brew

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import javax.inject.Inject

class ColdBrew(val appContext: Context) : Beverage(BeverageType.ColdBrew) {

    override fun brew() {
        Log.d(TAG, "Brewing delicious, refreshing cold brew")
        displayInAppNotification()
    }

    private fun displayInAppNotification() {
        Toast.makeText(appContext, "Your coldbrew has been ordered", Toast.LENGTH_LONG).show()
    }
}