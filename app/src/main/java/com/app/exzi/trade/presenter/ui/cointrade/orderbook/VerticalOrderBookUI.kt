package com.app.exzi.trade.presenter.ui.cointrade.orderbook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.domain.model.MarketDomainModel
import com.app.exzi.trade.presenter.ui.coindetail.orderbook.OrderBookList
import com.app.exzi.ui.theme.Green
import com.app.exzi.ui.theme.RED

@Composable
fun VerticalOrderBookUI(
    modifier: Modifier,
    bid: List<MarketOrderDomainModel>,
    ask: List<MarketOrderDomainModel>,
    isDescending: Boolean,
    market: ViewStates<MarketDomainModel>
) {
    val dynamicTextColor =
        if (!isDescending) MaterialTheme.colorScheme.Green else MaterialTheme.colorScheme.RED

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        OrderBookList(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth(),
            list = ask,
            isBuy = true
        )

        if (market is ViewStates.Success) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = market.data.price,
                color = dynamicTextColor
            )
            Text(
                text = "=\'$\'${market.data.price}",
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        OrderBookList(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth(),
            list = bid,
            isBuy = false
        )
    }

}