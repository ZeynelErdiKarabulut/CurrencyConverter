package com.zeynelerdi.fxratesample.di

import android.content.Context
import com.zeynelerdi.fxratesample.FxRatesApplication
import com.zeynelerdi.fxratesample.repo.CurrencyListRepository
import com.zeynelerdi.fxratesample.repo.network.CurrencyListApi
import com.zeynelerdi.fxratesample.repo.network.NetworkClientProvider
import com.zeynelerdi.fxratesample.ui.currencyList.CurrencyListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelBindings::class])
interface AppComponent {
    fun provideNetworkClientProvider(): NetworkClientProvider
    fun provideCurrencyListApi(): CurrencyListApi
    fun provideCurrencyListRepository(): CurrencyListRepository

    fun inject(currencyListFragment: CurrencyListFragment)

    companion object {
        fun get(context: Context): AppComponent = (context as FxRatesApplication).getAppComponent()
    }
}
