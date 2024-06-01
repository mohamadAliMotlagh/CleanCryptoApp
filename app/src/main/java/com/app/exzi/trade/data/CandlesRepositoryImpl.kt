package com.app.exzi.trade.data

import com.app.exzi.trade.data.mapper.CandleMapper
import com.app.exzi.trade.data.remote.candle.CandlesRemoteDataSource
import com.app.exzi.trade.domain.repositories.CandlesRepository
import com.app.exzi.trade.domain.model.CandleDomainModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CandlesRepositoryImpl @Inject constructor(
    private val candlesRemoteDataSource: CandlesRemoteDataSource,
    private val candleMapper: CandleMapper
) :
    CandlesRepository {
    override suspend fun getCandlesData(pairName: String): Result<CandleDomainModel> {
        return withContext(IO) {
            candlesRemoteDataSource.getCandles(pairName).map {
                candleMapper(it)
            }
        }

    }
}