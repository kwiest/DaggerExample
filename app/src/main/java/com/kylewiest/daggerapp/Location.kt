package com.kylewiest.daggerapp

import android.util.Log

class Location(val name: String) {
    private val TAG = "BLUEBOTTLE_LOCATION"

    fun acknowledgeOrder() = Log.d(TAG, "Order received at $name")
}