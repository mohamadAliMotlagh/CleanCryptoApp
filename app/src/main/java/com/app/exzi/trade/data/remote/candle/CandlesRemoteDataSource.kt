package com.app.exzi.trade.data.remote.candle

import com.app.exzi.trade.data.model.candle.CandleDataModel

interface CandlesRemoteDataSource {
    suspend fun getCandles(pairName:String): Result<List<CandleDataModel>>
}