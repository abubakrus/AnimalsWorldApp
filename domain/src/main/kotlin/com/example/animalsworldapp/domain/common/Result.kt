package com.example.animalsworldapp.domain.common


sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    val isSuccess: Boolean get() = this !is Error

    val iaError: Boolean get() = this !is Success

    fun copy(data: T): Result<T> {
        return when (this) {
            is Result.Error -> this
            is Result.Success -> Success(data)
        }
    }

    class Error<T>(message: String) : Result<T>(message = message)

    class Success<T>(data: T) : Result<T>(data = data, message = null)
}