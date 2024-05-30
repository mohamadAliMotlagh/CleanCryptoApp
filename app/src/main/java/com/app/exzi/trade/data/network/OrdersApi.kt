package com.app.exzi.trade.data.network

import com.app.exzi.trade.data.model.MarketOrdersDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface OrdersApi {
    @GET("/book/list")
    suspend fun get(
        @Query("pair_id") pair_id: String,
        @Query("buy") buy: Int = 1,
        @Query("sell") sell: Int = 1,
    ): MarketOrdersDataModel
}
