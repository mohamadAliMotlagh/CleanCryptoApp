package com.app.exzi.trade.domain

import com.app.exzi.trade.domain.candle.CandleDomainModel

interface CandlesRepository {
    suspend fun getCandlesData(pairName: String): Result<CandleDomainModel>
}