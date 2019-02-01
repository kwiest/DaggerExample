package com.kylewiest.daggerapp.beverage.drip

import android.util.Log
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.ingredient.Roast

class BellaDonovan : Beverage(BeverageType.Drip) {
    private val name = "Bella Donovan"

    val roast = Roast.BD

    override fun brew() {
        Log.d(TAG, "Brewing my delicious $name")
    }
}
