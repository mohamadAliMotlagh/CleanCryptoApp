package com.app.exzi.appnavigation

import com.app.exzi.core.navigator.NavigationDestination

sealed class Screens() : NavigationDestination {
    data object EXZI : Screens() {
        override fun route() = "home_route"
    }

    data object Markets : Screens() {
        override fun route() = "search_route"
    }

    data object Trade : Screens() {
        override fun route() = "profile_route"
    }

    data object Copy : Screens() {
        override fun route() = "copy_route"
    }

    data object Assets : Screens() {
        override fun route() = "assets_route"
    }

    data object Main : Screens() {
        override fun route() = "main_route"
    }

    data object CoinDetail : Screens() {
        override fun route() = "coinDetail_route"
    }
}
