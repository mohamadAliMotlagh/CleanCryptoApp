package com.app.exzi.trade.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.candle.CandleDomainModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.presenter.TradeViewModel
import com.app.exzi.trade.presenter.ui.candle.CandleUI
import com.app.exzi.trade.presenter.ui.orderbook.HorizontalOrderBooksUI

@Composable
fun VerticalTradingUI(
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
    candles: ViewStates<CandleDomainModel>,
) {

    Column(Modifier.fillMaxSize()) {
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
    VerticalTradingUI(listOf(), listOf(), ViewStates.Loading)
}