package com.app.exzi.trade.presenter.ui.coindetail

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.exzi.R
import com.app.exzi.core.viewstate.ViewStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailScreen() {

    val viewModel: CoinDetailViewModel = hiltViewModel()
    val ask by viewModel.askOrderBook.collectAsState()
    val bid by viewModel.bidOrderBook.collectAsState()
    val candles by viewModel.candles.collectAsState()
    val market by viewModel.marketDetailData.collectAsState()


    Scaffold(Modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            Column {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors()
                        .copy(containerColor = MaterialTheme.colorScheme.background),

                    title = {
                        if (market is ViewStates.Success) {
                            val marketData = market as ViewStates.Success
                            Row(
                                Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.pair),
                                    contentDescription = "pair",
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${marketData.data.mainName}/${marketData.data.secondName}",
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                            }
                        }
                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.clickable {
                                viewModel.navigateUp()
                            }
                        )
                    },
                    actions = {
                        Image(
                            painter = painterResource(R.drawable.favorite),
                            contentDescription = "favorite",
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(R.drawable.reply),
                            contentDescription = "reply",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
                HorizontalDivider(color = Color(0xFF333C57))
            }
        })
    { padding ->
        val configuration = LocalConfiguration.current

        if (configuration.orientation == ORIENTATION_PORTRAIT) {
            VerticalTradingUI(
                Modifier
                    .fillMaxSize()
                    .padding(padding),
                ask = ask,
                bid = bid,
                candles = candles,
                marketModel = market
            )
        } else {
            HorizontalTradingUI(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(start = 32.dp),
                ask = ask,
                bid = bid,
                candles = candles,
                market
            )
        }
    }
}