package com.ruliam.testsinandroid.repositories

import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult

interface AuthRepository {
    suspend fun loginUserWithEmailAndPassword(email: String, password: String): LoginResult
    suspend fun registerUserWithEmailAndPassword(email: String, password: String): RegisterResult
}