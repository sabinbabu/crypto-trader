package com.binwin.cryptotrader.domain.repository

import com.binwin.cryptotrader.data.remote.dto.CoinDTO
import com.binwin.cryptotrader.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailDTO
}