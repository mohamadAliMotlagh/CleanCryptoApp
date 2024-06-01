package com.app.exzi.appnavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.exzi.main.MainPageUI
import com.app.exzi.trade.presenter.ui.coindetail.TradingScreen
import com.app.exzi.ui.navigator.Navigator
import com.app.exzi.ui.navigator.NavigatorEvent


@Composable
fun AppNavigation(appNavigator: Navigator) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Main.route()
    ) {
        composable(
            route = Screens.Main.route(),
            Screens.Main.arguments
        ) {
            MainPageUI()
        }

        composable(
            route = Screens.CoinDetail.route(),
            arguments = Screens.CoinDetail.arguments
        ) {
            TradingScreen()
        }
    }

    LaunchedEffect(navController) {
        appNavigator.destinations.collect {
            when (val event = it) {
                is NavigatorEvent.NavigateUp -> {
                    navController.navigateUp()
                }

                is NavigatorEvent.Directions -> navController.navigate(
                    event.destination,
                    event.builder
                )

                NavigatorEvent.PopBackStack -> {
                    navController.popBackStack()
                }

                is NavigatorEvent.PopBackStackWithData -> {
                    event.bundle.keySet().forEach { key ->
                        navController
                            .previousBackStackEntry
                            ?.savedStateHandle?.set(
                                key,
                                event.bundle.getString(key)
                            )
                    }

                    navController.popBackStack()
                }
            }
        }
    }

}