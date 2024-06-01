package com.app.exzi.trade.data.di

import com.app.exzi.core.networking.NetworkManager
import com.app.exzi.trade.data.MarketOrdersRepositoryImpl
import com.app.exzi.trade.data.MarketsRepositoryImpl
import com.app.exzi.trade.data.mapper.marketDataModelToDomainModel
import com.app.exzi.trade.data.mapper.marketOrderBooksDataModelToDomainModel
import com.app.exzi.trade.data.network.MarketsApi
import com.app.exzi.trade.data.network.OrdersApi
import com.app.exzi.trade.data.remote.markets.MarketsRemoteDataSource
import com.app.exzi.trade.data.remote.markets.MarketsRemoteDataSourceImpl
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSource
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSourceImpl
import com.app.exzi.trade.domain.SingleMarketDetailUseCase
import com.app.exzi.trade.domain.repositories.MarketOrdersRepository
import com.app.exzi.trade.domain.repositories.MarketsRepository
import com.app.exzi.trade.domain.singleMarketDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarketsModule {
    @Singleton
    @Provides
    fun provideMarketsDataService(networkManager: NetworkManager): MarketsApi {
        return networkManager.create(MarketsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOrderBookRepository(
        remote: MarketsRemoteDataSource,
    ): MarketsRepository {
        return MarketsRepositoryImpl(
            marketsRemoteDataSource = remote,
            marketMapper = { marketDataModelToDomainModel(it) }
        )
    }

    @Provides
    fun provideSingleMarketDetailUseCase(repository: MarketsRepository): SingleMarketDetailUseCase {
        return SingleMarketDetailUseCase {
            singleMarketDetailUseCase(
                pairID = it,
                repository = repository
            )
        }
    }
}


@Module
@InstallIn(SingletonComponent::class)
abstract class MarketsBindSources {
    @Binds
    @Singleton
    abstract fun bindMarketRemoteDataSource(remote: MarketsRemoteDataSourceImpl): MarketsRemoteDataSource
}