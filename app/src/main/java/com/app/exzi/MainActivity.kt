package com.app.exzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.exzi.appnavigation.AppNavigation
import com.app.exzi.ui.navigator.Navigator
import com.app.exzi.ui.theme.CleanCryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator:Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CleanCryptoAppTheme {
                AppNavigation(navigator)
            }
        }
    }
}