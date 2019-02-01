package com.kylewiest.daggerapp.di

import android.content.Context
import com.kylewiest.daggerapp.MainApplication
import com.kylewiest.daggerapp.beverage.Session
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    ActivityModule::class,
    RepositoryModule::class
])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun session(session: Session): Builder

        fun repositoryModule(repositoryModule: RepositoryModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}
