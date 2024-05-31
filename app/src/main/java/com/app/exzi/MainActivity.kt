package com.app.exzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.exzi.trade.presenter.ui.TradingScreen
import com.app.exzi.ui.theme.CleanCryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanCryptoAppTheme {
                TradingScreen()
            }
        }
    }
}