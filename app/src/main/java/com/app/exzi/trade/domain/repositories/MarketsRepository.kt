package com.app.exzi.trade.domain.repositories

import com.app.exzi.trade.domain.model.MarketDomainModel
import kotlinx.coroutines.flow.Flow

interface MarketsRepository {
    suspend fun getAllMarkets(): Flow<Result<List<MarketDomainModel>>>
}