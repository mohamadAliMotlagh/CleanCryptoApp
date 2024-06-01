package com.app.exzi.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.exzi.appnavigation.Screens
import com.app.exzi.trade.presenter.ui.cointrade.TradeScreen

@Composable
fun MainPageUI() {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(Modifier.height(100.dp)) {
                NavigationBar(containerColor = Color(0xFF151823)) {
                    BottomNavigationItem().bottomNavigationItems()
                        .forEachIndexed { index, navigationItem ->
                            NavigationBarItem(
                                selected = index == navigationSelectedItem,
                                label = {
                                    Text(
                                        navigationItem.label,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                },
                                icon = {
                                    Icon(
                                        navigationItem.icon,
                                        contentDescription = navigationItem.label,
                                        modifier = Modifier.size(40.dp)
                                    )
                                },
                                onClick = {
                                    navigationSelectedItem = index
                                    navController.navigate(navigationItem.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                }
            }

        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Trade.route(),
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {

            composable(Screens.EXZI.route()) {
                Box(modifier = Modifier.fillMaxSize())
            }
            composable(Screens.Markets.route()) {
                Box(modifier = Modifier.fillMaxSize())
            }
            composable(Screens.Trade.route()) {
                TradeScreen()
            }
            composable(Screens.Copy.route()) {
                Box(modifier = Modifier.fillMaxSize())
            }
            composable(Screens.Assets.route()) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }
    }
}