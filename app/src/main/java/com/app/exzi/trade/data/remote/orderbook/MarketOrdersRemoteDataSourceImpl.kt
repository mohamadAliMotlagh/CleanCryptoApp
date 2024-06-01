package com.app.exzi.trade.data.remote.orderbook

import com.app.exzi.core.util.resultOf
import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.data.network.OrdersApi
import javax.inject.Inject

class MarketOrdersRemoteDataSourceImpl
    @Inject
    constructor(private val api: OrdersApi) :
    MarketOrdersRemoteDataSource {
        override suspend fun getOrdersFromApi(pairID: String): Result<MarketOrdersDataModel> {
            return resultOf { api.get(pairID) }
        }
    }
