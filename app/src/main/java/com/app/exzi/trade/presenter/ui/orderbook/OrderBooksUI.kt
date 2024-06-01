package com.app.exzi.trade.presenter.ui.orderbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.ui.theme.CleanCryptoAppTheme

@Composable
fun HorizontalOrderBooksUI(
    modifier: Modifier = Modifier,
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
) {

    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OrderBookList(
            Modifier.weight(1f),
            list = bid,
            isBuy = true,
            LayoutDirection.Rtl
        )
        Spacer(modifier = Modifier.width(8.dp))
        OrderBookList(
            Modifier.weight(1f),
            list = ask,
            isBuy = false,
        )
    }
}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0E111a)
fun OrderBooksUIPreview() {
    CleanCryptoAppTheme {


        HorizontalOrderBooksUI(ask = (0..100).map {
            MarketOrderDomainModel(
                price = "213213",
                fraction = 0.77f - (it / 10001f),
                quantity = "0.112"
            )
        }, bid = (0..100).map {
            MarketOrderDomainModel(
                price = "213213",
                fraction = 0.77f - (it / 10001),
                quantity = "0.112"
            )
        })
    }
}