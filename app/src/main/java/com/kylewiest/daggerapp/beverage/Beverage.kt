package com.kylewiest.daggerapp.beverage

abstract class Beverage(val type: BeverageType) {
    protected val TAG = "BLUEBOTTLE_$type"

    abstract fun brew()
}
