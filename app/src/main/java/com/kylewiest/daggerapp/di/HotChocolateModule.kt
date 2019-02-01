package com.kylewiest.daggerapp.di

import com.kylewiest.daggerapp.beverage.ingredient.Chocolate
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import dagger.Module
import dagger.Provides

@Module
class HotChocolateModule {
    @Provides
    fun provideMilk(): Milk = Milk.TWO_PERCENT

    @Provides
    fun provideChocolate(): Chocolate = Chocolate()
}
