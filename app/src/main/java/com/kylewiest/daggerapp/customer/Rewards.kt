package com.kylewiest.daggerapp.customer

import android.util.Log
import com.kylewiest.daggerapp.beverage.Beverage

class Rewards(val customerEmail: BBEmail) {
    private val TAG = "BLUEBOTTLE_REWARDS"

    fun credit(beverage: Beverage) {
        Log.d(TAG, "Crediting customer: $customerEmail for their ${beverage.type}")
    }
}
