package com.app.exzi.trade.data.mapper

import com.app.exzi.trade.data.model.MarketOrdersDataModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.MarketOrdersDomainModel

fun marketOrderBooksDataModelToDomainModel(marketOrderBooksDataModel: MarketOrdersDataModel): MarketOrdersDomainModel {

    val sellSum = ((marketOrderBooksDataModel.sell?.sumOf {
        (it.volume ?: 0) * (it.count ?: 0)
    } ?: 1).toFloat() / (marketOrderBooksDataModel.sell?.size?.toFloat() ?: 1f))

    val buySum = ((marketOrderBooksDataModel.buy?.sumOf {
        (it.volume ?: 0) * (it.count ?: 0)
    } ?: 1).toFloat() / (marketOrderBooksDataModel.buy?.size?.toFloat() ?: 1f))

    return MarketOrdersDomainModel(
        ask = marketOrderBooksDataModel.sell?.map {

            MarketOrderDomainModel(
                price = it.rate_f ?: "",
                fraction = ((it.volume ?: 0) / sellSum) * 0.5f,
                quantity = it.volume_f ?: ""

            )
        } ?: listOf(),

        bid = marketOrderBooksDataModel.buy?.map {
            MarketOrderDomainModel(
                price = it.rate_f ?: "",
                fraction = ((it.volume ?: 0) / buySum) * 0.5f,
                quantity = it.volume_f ?: ""

            )
        } ?: listOf()
    )
}