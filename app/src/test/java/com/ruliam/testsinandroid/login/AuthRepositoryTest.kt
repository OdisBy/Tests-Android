package com.ruliam.testsinandroid.login

import com.google.common.truth.Truth.assertThat
import com.ruliam.testsinandroid.login.repositories.FakeAuthRepository
import com.ruliam.testsinandroid.login.util.MainDispatcherRule
import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AuthRepositoryTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var repository: FakeAuthRepository

    @Before
    fun setup(){
        repository = FakeAuthRepository()
    }

    @Test
    fun `Login correct returns Success`() = runBlocking {
        repository.registerUserWithEmailAndPassword("unit.test@test.com", "correctPassword")
        val result = repository.loginUserWithEmailAndPassword("unit.test@test.com", "correctPassword")
        assertThat(result).isEqualTo(LoginResult.Success("fakeUserId"))

    }

    @Test
    fun `Try to login with email but account doesn't exist return error`() = runTest {
        val result = repository.loginUserWithEmailAndPassword("unit.test@test.com", "randomPassword")
        assertThat(result).isEqualTo(LoginResult.NotFoundAccount)
    }

    @Test
    fun `Try to login with wrong password returns error`() = runBlocking {
        repository.registerUserWithEmailAndPassword("unit.test@test.com", "correctPassword")
        val result = repository.loginUserWithEmailAndPassword("unit.test@test.com", "wrongPassword")

        assertThat(result).isEqualTo(LoginResult.WrongPassword)
    }

    @Test
    fun `Register User successfully returns true`() = runBlocking {
        val result = repository.registerUserWithEmailAndPassword("unit.test@test.com", "randomPassword")
        assertThat(result).isEqualTo(RegisterResult.Success)
    }

    @Test
    fun `Try to register with email already taken`() = runBlocking {
        repository.registerUserWithEmailAndPassword("unit.test@test.com", "randomPassword")
        val result = repository.registerUserWithEmailAndPassword("unit.test@test.com", "2randomPassword")

        assertThat(result).isEqualTo(RegisterResult.AlreadyHasAccount)
    }

}