package com.kylewiest.daggerapp.beverage.espresso

import android.util.Log
import com.kylewiest.daggerapp.Location
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import com.kylewiest.daggerapp.beverage.ingredient.Roast
import com.kylewiest.daggerapp.customer.Customer
import com.kylewiest.daggerapp.customer.Rewards

class Latte(
    val roast: Roast,
    val milk: Milk,
    val customer: Customer,
    val rewards: Rewards,
    val location: Location
) : Beverage(BeverageType.Latte) {

    override fun brew() {
        location.acknowledgeOrder()
        Log.d(TAG, "Brewing latte with $roast and $milk")
        customer.notifyViaApp()
        rewards.credit(this)
    }
}