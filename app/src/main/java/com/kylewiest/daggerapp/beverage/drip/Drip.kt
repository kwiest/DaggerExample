package com.kylewiest.daggerapp.beverage.drip

import android.util.Log
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.ingredient.Roast

class Drip(val roast: Roast) : Beverage(BeverageType.Drip) {
    override fun brew() {
        Log.d(TAG, "Brewed my delicious ${roast.fullName}!")
    }

    private fun name() = roast.fullName
}

