package com.ruliam.testsinandroid.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginUtilTest {
    @Test
    fun `Correct email input returns true`(){
        val result = LoginUtil.validateEmailInput("unit.test@test.com")
        assertThat(result).isTrue()
    }

    @Test
    fun `Empty email input returns false`(){
        val result = LoginUtil.validateEmailInput("")
        assertThat(result).isFalse()
    }

    @Test
    fun `2 char local part email input returns false`(){
        val result = LoginUtil.validateEmailInput("un@test.com")
        assertThat(result).isFalse()
    }

    @Test
    fun `3 char local part email input returns true`(){
        val result = LoginUtil.validateEmailInput("uni@test.com")
        assertThat(result).isTrue()
    }

    @Test
    fun `Incorrect email input returns false`(){
        val result = LoginUtil.validateEmailInput("unit.test.com")
        assertThat(result).isFalse()
    }

    @Test
    fun `Correct password input returns true`(){
        val result = LoginUtil.validatePasswordInput("randomPassword")
        assertThat(result).isTrue()
    }

    @Test
    fun `Empty password input returns false`(){
        val result = LoginUtil.validatePasswordInput("")
        assertThat(result).isFalse()
    }

    @Test
    fun `if password less than 6 returns false`(){
        val result = LoginUtil.validatePasswordInput("passw")
        assertThat(result).isFalse()
    }

    @Test
    fun `Confirm password match password returns true`(){
        val result = LoginUtil.validateConfirmPasswordInput("password", "password")
        assertThat(result).isTrue()
    }

    @Test
    fun `if confirm password doesn't match password returns false`(){
        val result = LoginUtil.validateConfirmPasswordInput("password", "passw0rd")
        assertThat(result).isFalse()
    }

}