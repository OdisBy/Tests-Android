package com.ruliam.testsinandroid.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruliam.testsinandroid.repositories.AuthRepository
import com.ruliam.testsinandroid.util.LoginResult
import com.ruliam.testsinandroid.util.RegisterResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _signInState = MutableStateFlow<LoginResult>(LoginResult.Empty)
    val signInState: StateFlow<LoginResult> = _signInState

    private val _signUpState = MutableStateFlow<RegisterResult>(RegisterResult.Empty)
    val signUpState: StateFlow<RegisterResult> = _signUpState

    fun loginUserWithEmailAndPassword(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _signInState.value = LoginResult.Loading
        try {
            _signInState.value = authRepository.loginUserWithEmailAndPassword(email, password)
        } catch(e: Exception) {
            _signInState.value = LoginResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }

    fun registerUserWithEmailAndPassword(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _signUpState.value = RegisterResult.Loading
        try{
            _signUpState.value = authRepository.registerUserWithEmailAndPassword(email, password)
        } catch(e: Exception) {
            _signUpState.value = RegisterResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}