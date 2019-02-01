package com.kylewiest.daggerapp

import android.util.Log
import com.kylewiest.daggerapp.beverage.Beverage

class Order(val bev: Beverage) {
    private val TAG = "BLUEBOTTLE_ORDER"

    fun commit() {
        Log.d(TAG, "Order committed. Starting beverage...")
        bev.brew()
    }
}
