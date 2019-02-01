package com.kylewiest.daggerapp.beverage.non_coffee

import android.util.Log
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.ingredient.Chocolate
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import javax.inject.Inject

class HotChocolate @Inject constructor(
    private val milk: Milk,
    private val chocolate: Chocolate
) : Beverage(BeverageType.HotChocolate) {

    override fun brew() {
        Log.d(TAG, "One delicious $milk hot chocolate coming up!")
    }
}