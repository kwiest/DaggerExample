package com.kylewiest.daggerapp.di

import com.kylewiest.daggerapp.Order
import com.kylewiest.daggerapp.beverage.Session
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    HotChocolateModule::class,
    MochaModule::class
])
interface MochaComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun session(session: Session): Builder

        fun addHotChocolate(module: HotChocolateModule): Builder

        fun addMochaModule(module: MochaModule): Builder

        fun build(): MochaComponent
    }

    fun mochaOrder(): Order
}


