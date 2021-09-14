package com.binwin.cryptotrader.di

import com.binwin.cryptotrader.common.Constants
import com.binwin.cryptotrader.data.remote.CoinPaprikaAPI
import com.binwin.cryptotrader.data.repository.CoinRepositoryImplementation
import com.binwin.cryptotrader.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // lives as long as our application
object AppModule {

    @Provides //function provides dependencies
    @Singleton // we only have a single instance
    fun providePaprikaApi(): CoinPaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI): CoinRepository{
        return CoinRepositoryImplementation(api)
    }
}