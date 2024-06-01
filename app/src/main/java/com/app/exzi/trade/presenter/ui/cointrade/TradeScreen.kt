package com.app.exzi.trade.presenter.ui.cointrade

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TradeScreen() {
    val viewModel: TradeViewModel = hiltViewModel()
    val ask by viewModel.askOrderBook.collectAsState()
    val bid by viewModel.bidOrderBook.collectAsState()
    val market by viewModel.marketDetailData.collectAsState()

    TradeUI(
        modifier = Modifier.fillMaxSize(),
        ask = ask,
        bid = bid,
        marketModel = market,
        showDetail = viewModel::navigateToDetail

    )
}