package com.app.exzi.trade.presenter.ui.pair

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.exzi.ui.theme.CleanCryptoAppTheme

@Composable
fun KeyValueComponent(modifier: Modifier = Modifier, key: String, value: String) {

    Column(modifier) {
        Text(
            text = key,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xff)
@Composable
fun KeyValueComponentPreview() {
    CleanCryptoAppTheme {
        KeyValueComponent(key = "24h Volume(USDT)", value = "112.76M")

    }
}