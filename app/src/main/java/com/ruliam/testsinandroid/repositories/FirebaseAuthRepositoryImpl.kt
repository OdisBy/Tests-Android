package com.ruliam.testsinandroid.repositories

import android.graphics.Bitmap
import com.ruliam.testsinandroid.model.UserDomain
import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult

class FirebaseAuthRepositoryImpl : FirebaseAuthRepository {
    override suspend fun loginUserWithEmailAndPassword(
        email: String,
        password: String
    ): LoginResult {
        TODO("Not yet implemented")
    }

    override suspend fun registerUserWithEmailAndPassword(
        email: String,
        password: String
    ): RegisterResult {
        TODO("Not yet implemented")
    }
}