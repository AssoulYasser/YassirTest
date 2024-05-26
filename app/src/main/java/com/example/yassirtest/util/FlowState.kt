package com.example.yassirtest.util

import java.lang.Exception

sealed class FlowState<out T> {
    data class Success<out T>(val data: T) : FlowState<T>()
    data class Failure(val exception: Exception) : FlowState<Nothing>()
    data object Loading : FlowState<Nothing>()
}
