package com.app.exzi.trade.data.remote

import com.app.exzi.trade.data.model.MarketOrdersDataModel

interface MarketOrdersRemoteDataSource {
    suspend fun getOrdersFromApi(pairID: String): Result<MarketOrdersDataModel>
}