package com.ruliam.testsinandroid.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginUtilTest {
    @Test
    fun `empty email returns false`(){
        val result = LoginUtil.validateLoginInput(
            "",
            "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`(){
        val result = LoginUtil.validateLoginInput(
            "unit.test@test.com",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `email doesn't exist return false`(){
        val result = LoginUtil.validateLoginInput(
            "false.test@test.com",
            "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password match email return true`(){
        val result = LoginUtil.validateLoginInput(
            "unit.test@test.com",
            "123456"
        )
        assertThat(result).isTrue()
    }
}