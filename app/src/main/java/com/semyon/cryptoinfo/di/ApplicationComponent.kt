package com.semyon.cryptoinfo.di

import android.app.Application
import com.semyon.cryptoinfo.presentation.CoinApp
import com.semyon.cryptoinfo.presentation.CoinDetailFragment
import com.semyon.cryptoinfo.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}