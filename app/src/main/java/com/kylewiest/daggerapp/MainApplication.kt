package com.kylewiest.daggerapp

import android.app.Activity
import android.app.Application
import com.kylewiest.daggerapp.beverage.Session
import com.kylewiest.daggerapp.di.DaggerAppComponent
import com.kylewiest.daggerapp.di.RepositoryModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .context(applicationContext)
            .session(Session())
            .repositoryModule(
                RepositoryModule(
                    "https://production.api.example.com",
                    "postgres://somelongawsstring"
                )
            )
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}