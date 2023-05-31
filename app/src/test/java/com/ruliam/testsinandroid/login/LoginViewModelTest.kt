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

class LoginViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: LoginViewModel

    private lateinit var repository: FakeAuthRepository

    @Before
    fun setup(){
        viewModel = LoginViewModel(FakeAuthRepository())
        repository = FakeAuthRepository()
    }

    @Test
    fun `Login correct returns Success`() = runBlocking {
        val user2 = viewModel.registerUserWithEmailAndPassword("unit.test@test.com", "correctPassword")
        val user = viewModel.loginUserWithEmailAndPassword("unit.test@test.com", "correctPassword")


        val value = viewModel.signInState.value
        assertThat(value).isEqualTo(LoginResult.Success("fakeUserId"))
    }

    @Test
    fun `Try to login with email but account doesn't exist return error`() = runTest {
        viewModel.loginUserWithEmailAndPassword("unit.test@test.com", "randomPassword")

        val value = viewModel.signInState.value
        assertThat(value).isEqualTo(LoginResult.NotFoundAccount)
    }

    @Test
    fun `Try to login with wrong password returns error`() = runBlocking {
        viewModel.registerUserWithEmailAndPassword("unit.test@test.com", "correctPassword")
        viewModel.loginUserWithEmailAndPassword("unit.test@test.com", "wrongPassword")

        val value = viewModel.signInState.value
        assertThat(value).isEqualTo(LoginResult.WrongPassword)
    }

    @Test
    fun `Register User successfully returns true`() = runBlocking {
        viewModel.registerUserWithEmailAndPassword("unit.test@test.com", "randomPassword")

        val value = viewModel.signUpState.value
        assertThat(value).isEqualTo(RegisterResult.Success)
    }

    @Test
    fun `Try to register with email already taken`() = runBlocking {
        viewModel.registerUserWithEmailAndPassword("unit.test@test.com", "randomPassword")
        viewModel.registerUserWithEmailAndPassword("unit.test@test.com", "2randomPassword")

        val value = viewModel.signUpState.value
        assertThat(value).isEqualTo(RegisterResult.AlreadyHasAccount)
    }

}