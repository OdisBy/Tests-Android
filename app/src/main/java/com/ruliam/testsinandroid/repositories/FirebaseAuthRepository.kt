package com.ruliam.testsinandroid.repositories

import android.graphics.Bitmap
import com.ruliam.testsinandroid.model.UserDomain
import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult

interface FirebaseAuthRepository {
    suspend fun loginUserWithEmailAndPassword(email: String, password: String): LoginResult
    suspend fun registerUserWithEmailAndPassword(email: String, password: String): RegisterResult
}