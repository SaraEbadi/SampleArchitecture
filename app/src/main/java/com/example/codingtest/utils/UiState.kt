package com.example.codingtest.utils

sealed class UiState<out T : Any?> {
    data class Success<out T : Any?>(val value: T) : UiState<T>()
    data class Error(val errorObject: ErrorObject? = null) : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
}