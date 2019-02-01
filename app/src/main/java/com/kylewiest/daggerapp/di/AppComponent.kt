package com.kylewiest.daggerapp.di

import android.content.Context
import com.kylewiest.daggerapp.MainActivity
import com.kylewiest.daggerapp.MainApplication
import com.kylewiest.daggerapp.beverage.cold_brew.ColdBrew
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Component(modules = [
    ActivityModule::class,
    BeverageModule::class
])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}

@Module
class BeverageModule {
    @Provides
    fun provideColdBrew(appContext: Context): ColdBrew = ColdBrew(appContext)
}
