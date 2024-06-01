package com.app.exzi.trade.data.remote.orderbook

import com.app.exzi.trade.data.model.MarketOrdersDataModel

interface MarketOrdersRemoteDataSource {
    suspend fun getOrdersFromApi(pairID: String): Result<MarketOrdersDataModel>
}
