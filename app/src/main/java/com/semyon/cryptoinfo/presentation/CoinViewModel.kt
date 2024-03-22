package com.semyon.cryptoinfo.presentation

import androidx.lifecycle.ViewModel
import com.semyon.cryptoinfo.domain.GetCoinInfoListUseCase
import com.semyon.cryptoinfo.domain.GetCoinInfoUseCase
import com.semyon.cryptoinfo.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }

}