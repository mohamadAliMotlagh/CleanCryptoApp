package com.app.exzi.core.viewstate

sealed class ViewStates<out T : Any> {
    data object Idle : ViewStates<Nothing>()

    data object Loading : ViewStates<Nothing>()

    data class Error(val message: String, val cause: Exception? = null) : ViewStates<Nothing>()

    data class Success<out T : Any>(val data: T) : ViewStates<T>()
}
