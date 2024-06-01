package com.app.exzi.trade.domain.model

data class MarketDomainModel(
    val name: String,
    val mainName: String,
    val secondName: String,
    val id: String,
    val price: String,
    val high24h: String,
    val low24h: String,
    val volume24hBTC: String,
    val volume24hUSDT: String,
    val percentChange: Float,
)
