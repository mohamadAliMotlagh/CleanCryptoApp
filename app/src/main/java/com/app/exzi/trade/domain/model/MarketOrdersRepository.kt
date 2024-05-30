package com.app.exzi.trade.domain.model

import kotlinx.coroutines.flow.Flow

interface MarketOrdersRepository {
    suspend fun getOrders(): Flow<Result<MarketOrdersDomainModel>>
}