package com.app.exzi.trade.data.di

import com.app.exzi.core.networking.NetworkManager
import com.app.exzi.trade.data.MarketOrdersRepositoryImpl
import com.app.exzi.trade.data.mapper.marketOrderBooksDataModelToDomainModel
import com.app.exzi.trade.data.network.OrdersApi
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSource
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSourceImpl
import com.app.exzi.trade.domain.repositories.MarketOrdersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrdersBookModule {
    @Singleton
    @Provides
    fun provideDataService(networkManager: NetworkManager): OrdersApi {
        return networkManager.create(OrdersApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOrderBookRepository(remote: MarketOrdersRemoteDataSource): MarketOrdersRepository {
        return MarketOrdersRepositoryImpl(
            remoteDataSource = remote,
            orderBooksMapper = { marketOrderBooksDataModelToDomainModel(it) },
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsDataSources {
    @Binds
    @Singleton
    abstract fun bindOrdersRemoteDataSource(remote: MarketOrdersRemoteDataSourceImpl): MarketOrdersRemoteDataSource
}
