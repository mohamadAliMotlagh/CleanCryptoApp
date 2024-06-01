package com.app.exzi.trade.presenter.ui

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.exzi.trade.presenter.TradeViewModel
import com.app.exzi.trade.presenter.ui.candle.CandleUI
import com.app.exzi.trade.presenter.ui.orderbook.HorizontalOrderBooksUI
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun TradingScreen() {

    val viewModel: TradeViewModel = hiltViewModel()
    val ask by viewModel.askOrderBook.collectAsState()
    val bid by viewModel.bidOrderBook.collectAsState()
    val candles by viewModel.candles.collectAsState()
    val market by viewModel.marketDetailData.collectAsState()

    Scaffold(Modifier.background(MaterialTheme.colorScheme.background)) { _ ->
        val configuration = LocalConfiguration.current

        if (configuration.orientation == ORIENTATION_PORTRAIT) {
            VerticalTradingUI(
                ask = ask,
                bid = bid,
                candles = candles,
                market

            )
        } else {
            HorizontalTradingUI(
                ask = ask,
                bid = bid,
                candles = candles,
                market
            )
        }
    }
}