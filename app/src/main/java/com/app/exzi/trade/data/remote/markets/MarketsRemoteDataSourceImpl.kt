package com.app.exzi.trade.data.remote.markets

import com.app.exzi.core.util.resultOf
import com.app.exzi.trade.data.model.market.MarketsDataModel
import com.app.exzi.trade.data.network.MarketsApi
import javax.inject.Inject

class MarketsRemoteDataSourceImpl
    @Inject
    constructor(private val api: MarketsApi) :
    MarketsRemoteDataSource {
        override suspend fun getAllMarkets(): Result<MarketsDataModel> {
            return resultOf { api.get() }
        }
    }
