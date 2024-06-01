package com.app.exzi.trade.presenter.ui.cointrade

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.exzi.R
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.MarketDomainModel
import com.app.exzi.trade.domain.model.MarketOrderDomainModel
import com.app.exzi.trade.presenter.ui.cointrade.createorder.CreateOrderUI
import com.app.exzi.trade.presenter.ui.cointrade.orderbook.VerticalOrderBookUI
import com.app.exzi.ui.theme.Green
import com.app.exzi.ui.theme.RED

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradeUI(
    modifier: Modifier = Modifier,
    ask: List<MarketOrderDomainModel>,
    bid: List<MarketOrderDomainModel>,
    marketModel: ViewStates<MarketDomainModel>,
    showDetail: () -> Unit,
) {
    val isDescending by remember {
        if (marketModel is ViewStates.Success) {
            mutableStateOf(marketModel.data.percentChange < 0)
        } else {
            mutableStateOf(false)
        }
    }
    val dynamicTextColor =
        if (!isDescending) MaterialTheme.colorScheme.Green else MaterialTheme.colorScheme.RED

    Scaffold(topBar = {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier =
                    Modifier.padding(
                        8.dp,
                    ),
            ) {
                Text(text = "Spot")
                Text(text = "Margin")
                Text(text = "Convert")
            }

            TopAppBar(
                colors =
                    TopAppBarDefaults.topAppBarColors()
                        .copy(containerColor = MaterialTheme.colorScheme.background),
                title = {
                    if (marketModel is ViewStates.Success) {
                        Row(
                            Modifier.fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.pair),
                                contentDescription = "pair",
                                tint = MaterialTheme.colorScheme.onBackground,
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${marketModel.data.mainName}/${marketModel.data.secondName}",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                            )

                            Text(
                                text = (if (isDescending) "" else "+") + marketModel.data.percentChange.toString() + "%",
                                style = MaterialTheme.typography.labelMedium,
                                color = dynamicTextColor,
                                modifier = Modifier,
                            )
                        }
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.chart),
                        contentDescription = "favorite",
                        modifier = Modifier.clickable { showDetail() },
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "reply",
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                },
            )
        }
    }) { paddingValues ->

        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
            ) {
                CreateOrderUI(
                    Modifier
                        .weight(0.6f)
                        .fillMaxHeight(),
                )
                VerticalOrderBookUI(
                    modifier = Modifier.weight(0.4f),
                    bid = bid,
                    ask = ask,
                    isDescending = isDescending,
                    market = marketModel,
                )
            }
        }
    }
}
