package com.kylewiest.daggerapp.beverage

import com.kylewiest.daggerapp.Location
import com.kylewiest.daggerapp.customer.Customer
import com.kylewiest.daggerapp.customer.Rewards

class Session() {
    val preferredLocationName = "Old Oakland"
    val customer = Customer("kylew@bluebottlecoffee.com")
    val rewards = Rewards(customer.email)
    val location = Location(preferredLocationName)
}