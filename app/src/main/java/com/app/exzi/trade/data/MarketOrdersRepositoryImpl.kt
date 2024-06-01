package com.app.exzi.trade.data

import com.app.exzi.trade.data.mapper.OrderBookMapper
import com.app.exzi.trade.data.remote.orderbook.MarketOrdersRemoteDataSource
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import com.app.exzi.trade.domain.repositories.MarketOrdersRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarketOrdersRepositoryImpl(
    private val remoteDataSource: MarketOrdersRemoteDataSource,
    private val orderBooksMapper: OrderBookMapper,
) : MarketOrdersRepository {
    companion object {
        private const val DELAY: Long = 1_000
    }

    override suspend fun getOrders(pairID: String): Flow<Result<MarketOrdersDomainModel>> =
        flow {
            while (true) {
                val result =
                    remoteDataSource.getOrdersFromApi(pairID).map {
                        orderBooksMapper(it)
                    }
                emit(result)
                delay(DELAY)
            }
        }
}
