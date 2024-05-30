package com.app.exzi.trade.domain.model

import com.app.exzi.trade.data.model.MarketOrder

data class MarketOrdersDomainModel(
    val bid: List<MarketOrderDomainModel>,
    val ask: List<MarketOrderDomainModel>
)

data class MarketOrderDomainModel(
    val volume: Long,
    val count: Int,
    val rate: Long,
    val price: Int,
    val rate_f: String,
    val volume_f: String
)