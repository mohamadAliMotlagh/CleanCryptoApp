package com.app.exzi.trade.presenter.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.CandleDomainModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.market.MarketDomainModel
import com.app.exzi.trade.presenter.ui.candle.CandleUI
import com.app.exzi.trade.presenter.ui.orderbook.HorizontalOrderBooksUI
import com.app.exzi.trade.presenter.ui.pair.PairDetailUI

@Composable
fun VerticalTradingUI(
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
    candles: ViewStates<CandleDomainModel>,
    model: ViewStates<MarketDomainModel>,
) {


    Column(Modifier.fillMaxSize()) {
        PairDetailUI(
            modifier = Modifier.fillMaxWidth(),
            model = model
        )
        CandleUI(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            candles = candles
        ) {}
        HorizontalOrderBooksUI(modifier = Modifier.fillMaxHeight(1f), ask, bid)
    }
}


@Preview
@Composable
fun VerticalTradingUIPreview() {
    VerticalTradingUI(listOf(), listOf(), ViewStates.Loading, ViewStates.Loading)
}