package com.kylewiest.daggerapp.di

import com.kylewiest.daggerapp.Location
import com.kylewiest.daggerapp.Order
import com.kylewiest.daggerapp.beverage.Session
import com.kylewiest.daggerapp.beverage.espresso.Mocha
import com.kylewiest.daggerapp.beverage.ingredient.Chocolate
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import com.kylewiest.daggerapp.beverage.ingredient.Roast
import com.kylewiest.daggerapp.customer.Customer
import com.kylewiest.daggerapp.customer.Rewards
import dagger.Module
import dagger.Provides

@Module
class MochaModule {
    @Provides
    fun provideEspresso(): Roast = Roast.HVE

    @Provides
    fun provideCustomer(session: Session): Customer = session.customer

    @Provides
    fun provideRewards(session: Session): Rewards = session.rewards

    @Provides
    fun providesLocation(session: Session): Location = session.location

    @Provides
    fun provideMocha(
        roast: Roast, milk: Milk, chocolate: Chocolate, customer: Customer, rewards: Rewards, location: Location
    ): Mocha = Mocha.Builder()
        .roast(roast)
        .milk(milk)
        .chocolate(chocolate)
        .add(customer)
        .add(rewards)
        .add(location)
        .build()

    @Provides
    fun provideMochaOrder(mocha: Mocha): Order = Order(mocha)
}
