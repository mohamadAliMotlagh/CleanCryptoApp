package com.app.exzi.trade.data.network

import com.app.exzi.trade.data.model.market.MarketsDataModel
import retrofit2.http.GET

interface MarketsApi {
    @GET("https://api.exzi.com/api/default/ticker")
    suspend fun get(): MarketsDataModel
}
