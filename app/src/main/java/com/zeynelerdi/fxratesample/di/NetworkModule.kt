package com.zeynelerdi.fxratesample.di

import com.zeynelerdi.fxratesample.repo.network.NetoworkConfig
import com.zeynelerdi.fxratesample.repo.network.NetworkClientProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideNetworkClientProvider(): NetworkClientProvider {
        return NetworkClientProvider(baseUrl, NetoworkConfig.TIMEOUT_MINS)
    }
}
