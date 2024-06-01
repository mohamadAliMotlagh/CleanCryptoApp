package com.app.exzi.trade.data

import com.app.exzi.trade.data.mapper.MarketMapper
import com.app.exzi.trade.data.remote.markets.MarketsRemoteDataSource
import com.app.exzi.trade.domain.repositories.MarketsRepository
import com.app.exzi.trade.domain.model.MarketDomainModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarketsRepositoryImpl @Inject constructor(
    private val marketsRemoteDataSource: MarketsRemoteDataSource,
    private val marketMapper: MarketMapper
) : MarketsRepository {
    companion object {
        private const val DELAY: Long = 1_000
    }

    override suspend fun getAllMarkets(): Flow<Result<List<MarketDomainModel>>> = flow {
        while (true) {
            val result = marketsRemoteDataSource.getAllMarkets().map {
                marketMapper(it)
            }
            emit(result)
            delay(DELAY)
        }
    }
}

