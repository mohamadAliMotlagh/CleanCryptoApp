package com.app.exzi.trade.presenter.ui.candle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.app.exzi.core.viewstate.ViewStates
import com.app.exzi.trade.domain.model.CandleDomainModel
import com.tradingview.lightweightcharts.api.chart.models.color.surface.SolidColor
import com.tradingview.lightweightcharts.api.chart.models.color.toIntColor
import com.tradingview.lightweightcharts.api.options.models.GridLineOptions
import com.tradingview.lightweightcharts.api.options.models.GridOptions
import com.tradingview.lightweightcharts.api.options.models.layoutOptions
import com.tradingview.lightweightcharts.api.options.models.localizationOptions
import com.tradingview.lightweightcharts.runtime.plugins.DateTimeFormat
import com.tradingview.lightweightcharts.runtime.plugins.PriceFormatter
import com.tradingview.lightweightcharts.runtime.plugins.TimeFormatter
import com.tradingview.lightweightcharts.view.ChartsView

@Composable
fun CandleUI(
    modifier: Modifier,
    candles: ViewStates<CandleDomainModel>,
    retryLoadCandles: () -> Unit
) {
    val backgroundColor = MaterialTheme.colorScheme.background.toArgb().toIntColor()
    val textColors = MaterialTheme.colorScheme.onBackground.toArgb().toIntColor()
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (candles) {
            is ViewStates.Error -> {
                Button(onClick = { retryLoadCandles() }) {
                    Text(text = "Retry")
                }
            }

            ViewStates.Idle -> {}
            ViewStates.Loading -> {
                CircularProgressIndicator()
            }

            is ViewStates.Success -> {
                AndroidView(modifier = Modifier.fillMaxSize(), factory = { ctx ->
                    ChartsView(ctx).apply {
                        api.applyOptions {
                            layout = layoutOptions {
                                background = SolidColor(backgroundColor)
                                textColor = textColors
                            }
                            grid = GridOptions(
                                vertLines = GridLineOptions(backgroundColor),
                                horzLines = GridLineOptions(
                                    Color.Gray.copy(alpha = 0.3f).toArgb().toIntColor()
                                )
                            )
                            localization = localizationOptions {
                                locale = "en-EN"
                                priceFormatter = PriceFormatter(template = "{price:#2:#2}$")
                                timeFormatter = TimeFormatter(
                                    locale = "en-EN", dateTimeFormat = DateTimeFormat.DATE
                                )
                            }

                        }
                        api.addCandlestickSeries {
                            it.setData(candles.data)
                        }
                    }

                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CandleUIPreview() {
    CandleUI(modifier = Modifier.fillMaxSize(), ViewStates.Loading) {}
}