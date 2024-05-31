package com.app.exzi.trade.data.mapper

import com.app.exzi.trade.data.model.candle.CandleDataModel
import com.app.exzi.trade.domain.candle.CandleDomainModel
import com.tradingview.lightweightcharts.api.series.models.BarData
import com.tradingview.lightweightcharts.api.series.models.Time
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun candleDataModelToDomainModel(dataModel: List<CandleDataModel>): CandleDomainModel {

    return dataModel.sortedBy { it.time?:0  }.map {
        BarData(
            time = Time.Utc(it.time?:0),
            open = it.openF?.toFloat() ?: 0.0f,
            close = it.closeF?.toFloat() ?: 0.0f,
            low = it.lowF?.toFloat() ?: 0.0f,
            high = it.highF?.toFloat() ?: 0.0f
        )
    }
}