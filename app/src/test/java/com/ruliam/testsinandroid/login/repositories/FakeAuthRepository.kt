package com.ruliam.testsinandroid.login.repositories

import com.ruliam.testsinandroid.model.AuthDomain
import com.ruliam.testsinandroid.repositories.AuthRepository
import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult
import java.util.UUID

class FakeAuthRepository: AuthRepository {

    private val authAccounts = mutableListOf<AuthDomain>()

    private var shouldReturnNetworkError = false
    private var shouldReturnNotCompletedAccount = false

    fun shouldReturnNotCompletedAccount(value: Boolean){
        shouldReturnNotCompletedAccount = value
    }

    fun shouldReturnNetworkError(value: Boolean){
        shouldReturnNetworkError = value
    }

    override suspend fun loginUserWithEmailAndPassword(
        email: String,
        password: String
    ): LoginResult {
        if(shouldReturnNetworkError){
            return LoginResult.Error("Network Error")
        }
        if(!checkIfAccountWithEmailExists(email)){
            return LoginResult.NotFoundAccount
        }

        // If email and password match return account, otherwise return null
        val account = authAccounts.find { it.email == email && it.password == password }

        if(account == null){
            return LoginResult.WrongPassword
        }

        if(shouldReturnNotCompletedAccount){
            return LoginResult.AccountNotCompleted
        }
        return LoginResult.Success("fakeUserId")

    }

    override suspend fun registerUserWithEmailAndPassword(
        email: String,
        password: String
    ): RegisterResult {
        if(checkIfAccountWithEmailExists(email)){
            return RegisterResult.AlreadyHasAccount
        }
        authAccounts.add(
            AuthDomain(
                uid = UUID.randomUUID().toString(),
                email = email,
                password = password
            )
        )
        return RegisterResult.Success
    }

    private fun checkIfAccountWithEmailExists(email: String): Boolean {
        return authAccounts.any {it.email == email}
    }

}