package com.kylewiest.daggerapp.di

import com.kylewiest.daggerapp.beverage.non_coffee.HotChocolate
import dagger.Component

@Component(modules = [
    HotChocolateModule::class
])
interface HotChocolateComponent {

    @Component.Builder
    interface Builder {

        fun addHotChocolate(module: HotChocolateModule): Builder

        fun build(): HotChocolateComponent
    }

    fun hotChocolate(): HotChocolate
}


