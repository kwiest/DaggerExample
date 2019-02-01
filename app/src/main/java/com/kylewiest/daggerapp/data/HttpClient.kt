package com.kylewiest.daggerapp.data

import android.util.Log

class HttpClient(private val baseUrl: String) {
    private val TAG: String = "BLUEBOTTLE_HTTP_CLIENT"

    fun makeRequest() {
        Log.d(TAG, "Making HTTP Request to $baseUrl.")
    }
}