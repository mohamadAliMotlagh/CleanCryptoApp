package com.app.exzi.trade.domain.repositories

import com.app.exzi.trade.domain.model.MarketOrdersDomainModel
import kotlinx.coroutines.flow.Flow

interface MarketOrdersRepository {
    suspend fun getOrders(pairID:String): Flow<Result<MarketOrdersDomainModel>>
}