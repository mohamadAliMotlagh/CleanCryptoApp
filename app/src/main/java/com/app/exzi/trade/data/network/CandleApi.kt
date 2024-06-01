package com.app.exzi.trade.data.network

import com.app.exzi.trade.data.model.candle.CandleDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CandleApi {
    @GET("/graph/hist")
    suspend fun get(
        @Query("t") pair_name: String,
        @Query("r") r: String = "D",
        @Query("limit") limit: Int = 500,
        @Query("end") end: Int = 1705363200,
    ): List<CandleDataModel>
}
