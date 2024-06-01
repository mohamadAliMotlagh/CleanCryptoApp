package com.app.exzi.trade.data.model

import androidx.annotation.Keep

@Keep
data class MarketOrdersDataModel(
    val buy: List<MarketOrder>?,
    val sell: List<MarketOrder>?,
)

@Keep
data class MarketOrder(
    val volume: Long?,
    val count: Int?,
    val rate: Long?,
    val price: Int?,
    val rate_f: String?,
    val volume_f: String?,
)
