package com.zeynelerdi.fxratesample.di

import com.zeynelerdi.fxratesample.repo.CurrencyListRepository
import com.zeynelerdi.fxratesample.repo.CurrencyListRepositoryImpl
import com.zeynelerdi.fxratesample.repo.dto.CurrencyListDtoMapperImpl
import com.zeynelerdi.fxratesample.repo.network.CurrencyListApi
import com.zeynelerdi.fxratesample.repo.network.NetworkClientProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCurrencyListApi(networkClientProvider: NetworkClientProvider): CurrencyListApi {
        return CurrencyListApi.create(networkClientProvider.getRetrofitClient())
    }

    @Singleton
    @Provides
    fun provideCurrencyListRepository(currencyListApi: CurrencyListApi): CurrencyListRepository {
        return CurrencyListRepositoryImpl(
            currencyListApi = currencyListApi,
            currencyListDtoMapper = CurrencyListDtoMapperImpl()
        )
    }
}
