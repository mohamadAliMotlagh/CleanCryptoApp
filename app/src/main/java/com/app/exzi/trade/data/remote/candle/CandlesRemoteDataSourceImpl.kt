package com.app.exzi.trade.data.remote.candle

import com.app.exzi.core.util.resultOf
import com.app.exzi.trade.data.model.candle.CandleDataModel
import com.app.exzi.trade.data.network.CandleApi
import javax.inject.Inject

class CandlesRemoteDataSourceImpl @Inject constructor(private val api: CandleApi) : CandlesRemoteDataSource {
    override suspend fun getCandles(pairName: String): Result<List<CandleDataModel>> {
        return resultOf { api.get(pairName) }
    }
}