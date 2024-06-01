package com.app.exzi.trade.domain.repositories

import com.app.exzi.trade.domain.model.CandleDomainModel

interface CandlesRepository {
    suspend fun getCandlesData(pairName: String): Result<CandleDomainModel>
}
