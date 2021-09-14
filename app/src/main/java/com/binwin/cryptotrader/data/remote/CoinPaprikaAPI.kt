package com.binwin.cryptotrader.data.remote

import com.binwin.cryptotrader.data.remote.dto.CoinDTO
import com.binwin.cryptotrader.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinID: String): CoinDetailDTO
}