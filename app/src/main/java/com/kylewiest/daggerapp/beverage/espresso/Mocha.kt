package com.kylewiest.daggerapp.beverage.espresso

import android.util.Log
import com.kylewiest.daggerapp.*
import com.kylewiest.daggerapp.beverage.Beverage
import com.kylewiest.daggerapp.beverage.BeverageType
import com.kylewiest.daggerapp.beverage.ingredient.Roast
import com.kylewiest.daggerapp.beverage.ingredient.Chocolate
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import com.kylewiest.daggerapp.customer.Customer
import com.kylewiest.daggerapp.customer.Rewards

class Mocha private constructor(builder: Mocha.Builder) : Beverage(BeverageType.Mocha) {

    val roast: Roast
    val milk: Milk
    val chocolate: Chocolate

    val customer: Customer?
    val rewards: Rewards?
    val location: Location?

    init {
        roast = builder.roast
        milk = builder.milk
        chocolate = builder.chocolate
        customer = builder.customer
        rewards = builder.rewards
        location = builder.location
    }

    override fun brew() {
        location?.acknowledgeOrder()
        Log.d(TAG, "Brewing mocha with $roast and $milk")
        customer?.notifyViaApp()
        rewards?.credit(this)
    }

    class Builder {
        lateinit var roast: Roast
        lateinit var milk: Milk
        lateinit var chocolate: Chocolate

        var customer: Customer? = null
        var rewards: Rewards? = null
        var location: Location? = null

        fun roast(roast: Roast): Builder = apply { this.roast = roast }
        fun milk(milk: Milk): Builder = apply { this.milk = milk }
        fun chocolate(chocolate: Chocolate): Builder = apply { this.chocolate = chocolate }

        fun add(customer: Customer): Builder = apply { this.customer = customer }
        fun add(rewards: Rewards): Builder = apply { this.rewards = rewards }
        fun add(location: Location): Builder = apply { this.location = location }

        fun build() = Mocha(this)
    }
}