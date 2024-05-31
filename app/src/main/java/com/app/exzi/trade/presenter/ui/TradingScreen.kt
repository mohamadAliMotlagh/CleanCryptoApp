package com.app.exzi.trade.presenter.ui

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.exzi.trade.presenter.TradeViewModel
import com.app.exzi.trade.presenter.ui.orderbook.HorizontalOrderBooksUI
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun TradingScreen() {

    val viewModel: TradeViewModel = hiltViewModel()
    val ask by viewModel.askOrderBook.collectAsState()
    val bid by viewModel.bidOrderBook.collectAsState()

    Scaffold(Modifier.background(MaterialTheme.colorScheme.background)) { _ ->
        HorizontalOrderBooksUI(ask, bid)
    }
}