package com.ruliam.testsinandroid.util

sealed class RegisterResult {
    object Success: RegisterResult()
    data class Error(val message: String): RegisterResult()
    object AlreadyHasAccount: RegisterResult()
    object Empty: RegisterResult()
    object Loading: RegisterResult()
}