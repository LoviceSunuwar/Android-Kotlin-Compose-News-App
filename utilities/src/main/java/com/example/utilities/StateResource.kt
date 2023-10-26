package com.example.utilities

sealed class StateResource<T>() {
    class Loading<T> : StateResource<T>()
    data class Success<T> (val data:T) : StateResource<T>()
    data class Error<T> (val error: String) : StateResource<T>()
}
