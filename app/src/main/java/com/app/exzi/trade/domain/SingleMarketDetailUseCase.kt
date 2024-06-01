package com.app.exzi.trade.domain

import com.app.exzi.trade.domain.model.market.MarketDomainModel
import com.app.exzi.trade.domain.repositories.MarketsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun interface SingleMarketDetailUseCase : suspend (String) -> Flow<Result<MarketDomainModel>>


suspend fun singleMarketDetailUseCase(
    pairID: String,
    repository: MarketsRepository
): Flow<Result<MarketDomainModel>> {
    return repository.getAllMarkets().map { result ->
        result.mapCatching { list ->
            list.find { it.id == pairID }!!
        }
    }
}
