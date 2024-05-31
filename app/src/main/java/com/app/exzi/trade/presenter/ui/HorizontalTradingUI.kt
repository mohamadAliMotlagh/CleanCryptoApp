package com.app.exzi.trade.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun HorizontalTradingUI(
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
    candles: ViewStates<CandleDomainModel>,
) {

    Row(Modifier.fillMaxSize()) {

        HorizontalOrderBooksUI(modifier = Modifier.weight(0.5f), ask, bid)

        CandleUI(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth()
                .fillMaxHeight(),
            candles = candles
        ) {}
    }
}


@Preview
@Composable
fun HorizontalTradingUIPreview() {
    HorizontalTradingUI(listOf(), listOf(), ViewStates.Loading)
}