package com.semyon.cryptoinfo.di

import android.app.Application
import com.semyon.cryptoinfo.data.database.AppDatabase
import com.semyon.cryptoinfo.data.database.CoinInfoDao
import com.semyon.cryptoinfo.data.network.ApiFactory
import com.semyon.cryptoinfo.data.network.ApiService
import com.semyon.cryptoinfo.data.repository.CoinRepositoryImpl
import com.semyon.cryptoinfo.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }

}