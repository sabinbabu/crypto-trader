package com.binwin.cryptotrader.data.repository

import com.binwin.cryptotrader.data.remote.CoinPaprikaAPI
import com.binwin.cryptotrader.data.remote.dto.CoinDTO
import com.binwin.cryptotrader.data.remote.dto.CoinDetailDTO
import com.binwin.cryptotrader.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaAPI
): CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}