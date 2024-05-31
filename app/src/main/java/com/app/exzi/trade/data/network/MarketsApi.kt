package com.app.exzi.trade.data.network

import com.app.exzi.trade.data.model.candle.CandleDataModel
import com.app.exzi.trade.data.model.market.MarketsDataModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MarketsApi {
    @GET("https://api.exzi.com/api/default/ticker")
    suspend fun get(): MarketsDataModel
}