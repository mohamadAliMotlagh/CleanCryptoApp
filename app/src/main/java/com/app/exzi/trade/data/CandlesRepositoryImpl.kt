package com.app.exzi.trade.data

import com.app.exzi.core.util.Mapper
import com.app.exzi.trade.data.model.candle.CandleDataModel
import com.app.exzi.trade.data.remote.candle.CandlesRemoteDataSource
import com.app.exzi.trade.domain.CandlesRepository
import com.app.exzi.trade.domain.candle.CandleDomainModel
import javax.inject.Inject

class CandlesRepositoryImpl @Inject constructor(
    private val candlesRemoteDataSource: CandlesRemoteDataSource,
    private val candleMapper: Mapper<List<CandleDataModel>, CandleDomainModel>
) :
    CandlesRepository {
    override suspend fun getCandlesData(pairName: String): Result<CandleDomainModel> {
        return candlesRemoteDataSource.getCandles(pairName).map {
            candleMapper(it)
        }
    }
}