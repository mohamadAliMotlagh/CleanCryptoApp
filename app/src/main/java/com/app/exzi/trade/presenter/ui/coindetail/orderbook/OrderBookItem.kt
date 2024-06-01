package com.app.exzi.trade.presenter.ui.coindetail.orderbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.ui.theme.CleanCryptoAppTheme
import com.app.exzi.ui.theme.Green
import com.app.exzi.ui.theme.GreenDarker
import com.app.exzi.ui.theme.RED
import com.app.exzi.ui.theme.RedDarker

@Composable
fun OrderBookItem(
    modifier: Modifier = Modifier,
    data: MarketOrderDomainModel,
    isBuy: Boolean,
    direction: LayoutDirection
) {

    CompositionLocalProvider(LocalLayoutDirection provides direction) {

        Box(
            modifier
                .fillMaxWidth()
                .height(20.dp)
        ) {

            Row() {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(fraction = data.fraction)
                        .background(if (isBuy) MaterialTheme.colorScheme.GreenDarker else MaterialTheme.colorScheme.RedDarker)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.price,
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (isBuy) MaterialTheme.colorScheme.Green else MaterialTheme.colorScheme.RED
                )
                Text(
                    text = data.quantity,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}


@Preview
@Composable
fun OrderBookItemPreview() {
    CleanCryptoAppTheme {
        Column {
            (0..10).forEach {
                Spacer(modifier = Modifier.height(1.dp))
                OrderBookItem(
                    data = MarketOrderDomainModel(
                        price = "213213", fraction = 0.77f - (it / 12f), quantity = "0.112"
                    ),
                    isBuy = it % 3 == 0,
                    direction = if (it % 2 == 1) LayoutDirection.Ltr else LayoutDirection.Rtl
                )
            }
        }
    }

}