package com.binwin.cryptotrader.presentation.CoinDetail

import com.binwin.cryptotrader.domain.model.Coin
import com.binwin.cryptotrader.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
