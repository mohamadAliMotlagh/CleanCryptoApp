package com.app.exzi.trade.data.di

import com.app.exzi.core.networking.NetworkManager
import com.app.exzi.trade.data.CandlesRepositoryImpl
import com.app.exzi.trade.data.MarketOrdersRepositoryImpl
import com.app.exzi.trade.data.mapper.candleDataModelToDomainModel
import com.app.exzi.trade.data.mapper.marketOrderBooksDataModelToDomainModel
import com.app.exzi.trade.data.network.CandleApi
import com.app.exzi.trade.data.network.OrdersApi
import com.app.exzi.trade.data.remote.candle.CandlesRemoteDataSource
import com.app.exzi.trade.data.remote.candle.CandlesRemoteDataSourceImpl
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSource
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSourceImpl
import com.app.exzi.trade.domain.CandlesRepository
import com.app.exzi.trade.domain.MarketOrdersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CandlesModule {
    @Singleton
    @Provides
    fun provideDataService(networkManager: NetworkManager): CandleApi {
        return networkManager.create(CandleApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCandleRepository(
        remote: CandlesRemoteDataSource,
    ): CandlesRepository {
        return CandlesRepositoryImpl(
            candlesRemoteDataSource = remote,
            candleMapper = { candleDataModelToDomainModel(it) }
        )
    }
}


@Module
@InstallIn(SingletonComponent::class)
abstract class BindsCandleDataSources {
    @Binds
    @Singleton
    abstract fun bindsCandlesRemoteDataSource(remote: CandlesRemoteDataSourceImpl): CandlesRemoteDataSource
}