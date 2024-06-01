package com.app.exzi.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.exzi.appnavigation.Screens

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = "",
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.EXZI.route(),
            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = Screens.Markets.route(),
            ),
            BottomNavigationItem(
                label = "Trade",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Trade.route(),
            ),
            BottomNavigationItem(
                label = "Copy",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Copy.route(),
            ),
            BottomNavigationItem(
                label = "Assets",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Assets.route(),
            ),
        )
    }
}
