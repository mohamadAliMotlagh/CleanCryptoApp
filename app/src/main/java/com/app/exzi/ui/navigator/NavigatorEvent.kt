package com.app.exzi.ui.navigator

import android.os.Bundle
import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()

    class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit,
    ) : NavigatorEvent()

    object PopBackStack : NavigatorEvent()

    data class PopBackStackWithData(val bundle: Bundle) : NavigatorEvent()
}
