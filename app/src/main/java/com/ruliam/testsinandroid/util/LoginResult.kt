package com.ruliam.testsinandroid.util

sealed class LoginResult {
    data class Success(val userId: String): LoginResult()
    data class Error(val message: String): LoginResult()
    object AccountNotCompleted: LoginResult()
    object NotFoundAccount: LoginResult()
    object WrongPassword: LoginResult()
    object Empty: LoginResult()
    object Loading: LoginResult()
}