package com.app.exzi.trade.data.remote.markets

import com.app.exzi.trade.data.model.market.MarketsDataModel

interface MarketsRemoteDataSource {
    suspend fun getAllMarkets(): Result<MarketsDataModel>
}
