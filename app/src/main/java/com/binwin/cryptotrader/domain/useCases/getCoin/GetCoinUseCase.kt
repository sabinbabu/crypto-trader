package com.binwin.cryptotrader.domain.useCases.getCoin

import com.binwin.cryptotrader.common.Resource
import com.binwin.cryptotrader.data.remote.dto.toCoin
import com.binwin.cryptotrader.data.remote.dto.toCoinDetail
import com.binwin.cryptotrader.domain.model.Coin
import com.binwin.cryptotrader.domain.model.CoinDetail
import com.binwin.cryptotrader.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}