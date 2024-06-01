package com.app.exzi.trade.presenter.ui.coindetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.CandleDomainModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.market.MarketDomainModel
import com.app.exzi.trade.presenter.ui.coindetail.candle.CandleUI
import com.app.exzi.trade.presenter.ui.coindetail.orderbook.HorizontalOrderBooksUI
import com.app.exzi.trade.presenter.ui.coindetail.pair.PairDetailUI

@Composable
fun VerticalTradingUI(
    modifier: Modifier = Modifier,
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
    candles: ViewStates<CandleDomainModel>,
    marketModel: ViewStates<MarketDomainModel>,
) {


    Column(modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        PairDetailUI(
            modifier = Modifier.fillMaxWidth(),
            model = marketModel
        )
        Spacer(modifier = Modifier.height(16.dp))
        CandleUI(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            candles = candles,
            retryLoadCandles = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalOrderBooksUI(modifier = Modifier.fillMaxHeight(1f), ask, bid)
    }
}


@Preview
@Composable
fun VerticalTradingUIPreview() {
//    VerticalTradingUI(
//        modifier = Modifier,
//        listOf(),
//        listOf(),
//        ViewStates.Loading,
//        ViewStates.Loading
//    )
}