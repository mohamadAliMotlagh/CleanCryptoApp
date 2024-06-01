package com.app.exzi.appnavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.app.exzi.main.MainPageUI
import com.app.exzi.trade.presenter.ui.coindetail.CoinDetailScreen
import com.app.exzi.core.navigator.Navigator
import com.app.exzi.core.navigator.NavigatorEvent
import com.google.accompanist.navigation.material.BottomSheetNavigatorSheetState
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator


@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun AppNavigation(appNavigator: Navigator) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()

    val navController = rememberNavController(bottomSheetNavigator)
    ModalBottomSheetLayout(bottomSheetNavigator) {
        bottomSheetNavigator.navigatorSheetState
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
                CoinDetailScreen()
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

}