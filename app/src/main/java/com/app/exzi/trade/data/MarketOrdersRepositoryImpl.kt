package com.app.exzi.trade.data

import com.app.exzi.core.util.Mapper
import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.data.remote.MarketOrdersRemoteDataSource
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import com.app.exzi.trade.domain.model.MarketOrdersRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow

class MarketOrdersRepositoryImpl(
    private val remoteDataSource: MarketOrdersRemoteDataSource,
    private val orderBooksMapper: Mapper<MarketOrdersDataModel, MarketOrdersDomainModel>
) :
    MarketOrdersRepository {
    override suspend fun getOrders(pairID: String): Flow<Result<MarketOrdersDomainModel>> = flow {
        while (true) {
            val result = remoteDataSource.getOrdersFromApi(pairID).map {
                orderBooksMapper(it)
            }

            emit(result)
            delay(5000)
        }
    }.cancellable()
}