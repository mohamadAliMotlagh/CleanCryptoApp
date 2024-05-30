package com.app.exzi.core.networking.di

import com.app.exzi.core.networking.NetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkManager(): NetworkManager {
        return NetworkManager()
    }
}
