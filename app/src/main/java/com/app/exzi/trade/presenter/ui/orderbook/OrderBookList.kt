package com.app.exzi.trade.presenter.ui.orderbook

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.ui.theme.CleanCryptoAppTheme

@Composable
fun OrderBookList(
    modifier: Modifier = Modifier,
    list: List<MarketOrderDomainModel>,
    isBuy: Boolean,
    direction: LayoutDirection = LayoutDirection.Ltr
) {
    LazyColumn(modifier.fillMaxSize()) {
        items(list) {
            OrderBookItem(data = it, isBuy = isBuy, direction = direction)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OrderBookListPreview() {
    CleanCryptoAppTheme {
        OrderBookList(
            list = (0..10).map {
                MarketOrderDomainModel(
                    price = "213213",
                    fraction = 0.77f - (it / 12f),
                    quantity = "0.112"
                )
            },
            isBuy = true,
            direction = LayoutDirection.Ltr
        )
    }
}

@Composable
@Preview(showBackground = true)
fun OrderBookListPreviewSell() {
    CleanCryptoAppTheme {
        OrderBookList(
            list = (0..10).map {
                MarketOrderDomainModel(
                    price = "213213",
                    fraction = 0.77f - (it / 12f),
                    quantity = "0.112"
                )
            },
            isBuy = false,
            direction = LayoutDirection.Rtl
        )
    }
}