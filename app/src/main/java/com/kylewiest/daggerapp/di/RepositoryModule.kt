package com.kylewiest.daggerapp.di

import com.kylewiest.daggerapp.data.HttpClient
import com.kylewiest.daggerapp.data.LocationApiService
import com.kylewiest.daggerapp.data.LocationDatabaseAdapter
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule(val apiBaseUrl: String, val databaseUrl: String) {
    @Provides
    fun provideHttpClient(): HttpClient = HttpClient(apiBaseUrl)

    @Provides
    fun provideLocationApiService(httpClient: HttpClient): LocationApiService = LocationApiService(httpClient)

    @Provides
    fun provideLocationDatabaseAdapter(): LocationDatabaseAdapter = LocationDatabaseAdapter(databaseUrl)
}
