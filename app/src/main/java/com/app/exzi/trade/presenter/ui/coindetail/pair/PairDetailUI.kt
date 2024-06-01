package com.app.exzi.trade.presenter.ui.coindetail.pair

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.app.exzi.core.components.shimmerEffect
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.MarketDomainModel
import com.app.exzi.ui.theme.CleanCryptoAppTheme
import com.app.exzi.ui.theme.Green
import com.app.exzi.ui.theme.RED

@Composable
fun PairDetailUI(modifier: Modifier = Modifier, model: ViewStates<MarketDomainModel>) {


    when (model) {
        is ViewStates.Error -> {
            //TODO("Need to handle Error.")
        }
        ViewStates.Idle -> {
            //TODO("Need to implement this or show loading")
        }

        ViewStates.Loading -> {
            Box(modifier.shimmerEffect(MaterialTheme.colorScheme.onSecondary))
        }

        is ViewStates.Success -> {
            ConstraintLayout(modifier) {
                val (price, secondPrice, percent, high24, low24, amount24, volume24) = createRefs()
                val market = model.data
                val isDescending by remember {
                    mutableStateOf(market.percentChange < 0)
                }
                val dynamicTextColor =
                    if (!isDescending) MaterialTheme.colorScheme.Green else MaterialTheme.colorScheme.RED

                Text(
                    text = market.price,
                    style = MaterialTheme.typography.headlineSmall,
                    color = dynamicTextColor,
                    modifier = Modifier.constrainAs(price) {
                        start.linkTo(parent.start)
                    }
                )

                Text(
                    text = market.price,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.constrainAs(secondPrice) {
                        start.linkTo(parent.start)
                        top.linkTo(price.bottom, 8.dp)
                    }
                )

                Text(
                    text = (if (isDescending) "" else "+") + market.percentChange.toString() + "%",
                    style = MaterialTheme.typography.labelMedium,
                    color = dynamicTextColor,
                    modifier = Modifier.constrainAs(percent) {
                        start.linkTo(secondPrice.end, 4.dp)
                        top.linkTo(price.bottom, 8.dp)
                    }
                )

                KeyValueComponent(
                    key = "24h Low",
                    value = market.low24h,
                    modifier = Modifier.constrainAs(low24) {
                        start.linkTo(volume24.start)
                    })

                KeyValueComponent(
                    key = "24h High",
                    value = market.high24h,
                    modifier = Modifier.constrainAs(high24) {
                        start.linkTo(amount24.start)
                    })

                KeyValueComponent(
                    key = "24h Amount(${market.mainName})",
                    value = market.volume24hBTC,
                    modifier = Modifier.constrainAs(amount24) {
                        end.linkTo(volume24.start, 16.dp)
                        top.linkTo(high24.bottom, 8.dp)
                    })

                KeyValueComponent(
                    key = "24h Volume(${market.secondName})",
                    value = market.volume24hUSDT,
                    modifier = Modifier.constrainAs(volume24) {
                        end.linkTo(parent.end)
                        top.linkTo(high24.bottom, 8.dp)
                    })


            }
        }
    }


}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF0E111a
)
@Composable
fun PairDetailUIPreview() {
    CleanCryptoAppTheme {
        PairDetailUI(
            Modifier
                .fillMaxWidth(),
            ViewStates.Success(
                MarketDomainModel(
                    name = "BTCUSDT",
                    mainName = "BTC",
                    secondName = "USDT",
                    id = "4001",
                    price = "30000.00",
                    high24h = "31000.00",
                    low24h = "29500.00",
                    volume24hBTC = "1234.56",
                    volume24hUSDT = "37000000.00",
                    percentChange = 0.3f,
                )
            )
        )
    }
}