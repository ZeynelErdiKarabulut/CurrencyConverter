package com.zeynelerdi.fxratesample

import android.app.Application
import com.zeynelerdi.fxratesample.di.AppComponent
import com.zeynelerdi.fxratesample.di.AppModule
import com.zeynelerdi.fxratesample.di.DaggerAppComponent
import com.zeynelerdi.fxratesample.di.NetworkModule
import com.zeynelerdi.fxratesample.repo.network.NetoworkConfig

interface FxRatesApplication {
    fun getAppComponent(): AppComponent
}

class MainApplication : Application(), FxRatesApplication {
    override fun getAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule(NetoworkConfig.BASE_URL))
            .appModule(AppModule())
            .build()
    }
}
