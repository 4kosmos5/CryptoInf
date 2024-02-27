package com.semyon.cryptoinfo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.semyon.cryptoinfo.data.repository.CoinRepositoryImpl
import com.semyon.cryptoinfo.domain.GetCoinInfoListUseCase
import com.semyon.cryptoinfo.domain.GetCoinInfoUseCase
import com.semyon.cryptoinfo.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }

}