package com.app.exzi.trade.data.mapper

import com.app.exzi.core.util.Mapper
import com.app.exzi.core.util.decimalNumberSeparator
import com.app.exzi.trade.data.model.market.MarketsDataModel
import com.app.exzi.trade.domain.model.MarketDomainModel
import java.util.Locale

typealias MarketMapper = Mapper<MarketsDataModel, List<MarketDomainModel>>
//TODO it needs unit test
fun marketDataModelToDomainModel(dataModel: MarketsDataModel): List<MarketDomainModel> {
    return dataModel.data?.map {
        MarketDomainModel(
            name = it?.name ?: "",
            id = it?._id ?: "",
            mainName = it?.main?.iso3 ?: "",
            secondName = it?.second?.iso3 ?: "",
            price = (it?.rateF ?: "").decimalNumberSeparator(),
            high24h = (it?.highF ?: "").decimalNumberSeparator(),
            low24h = (it?.lowF ?: "").decimalNumberSeparator(),
            volume24hBTC = (it?.volumeF ?: "").decimalNumberSeparator(),
            volume24hUSDT = ((it?.volumeF ?: "0").toBigDecimal() * (it?.rateF
                ?: "0").toBigDecimal()).toString().decimalNumberSeparator(), //Amount 24
            percentChange = String.format(Locale.getDefault(), "%.2f", it?.percent ?: 0.0f)
                .toFloat()
        )
    } ?: listOf()
}