package com.kylewiest.daggerapp.customer

import android.util.Log

typealias BBEmail = String

class Customer(val email: BBEmail) {
    private val TAG = "BLUEBOTTLE_CUSTOMER"

    fun notifyViaApp() {
        Log.d(TAG, "Sending app notification to $email")
    }
}
