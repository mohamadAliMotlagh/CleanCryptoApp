package com.app.exzi.trade.domain.model

data class MarketOrdersDomainModel(
    val bid: List<MarketOrderDomainModel>,
    val ask: List<MarketOrderDomainModel>,
)

data class MarketOrderDomainModel(
    val price: String,
    val fraction: Float,
    val quantity: String,
)
