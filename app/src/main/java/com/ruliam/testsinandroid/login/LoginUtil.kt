package com.ruliam.testsinandroid.login

object LoginUtil {
    private data class AccountLogin(val email: String, val password: String)

    private val existingAccounts = listOf(
        AccountLogin(
            "unit.test@test.com",
            "123456"
        ),
        AccountLogin(
            "unit2.test@test.com",
            "654321"
        )
    )

    /**
     * the input is not valid if...
     * ...the email/password is empty
     * ...the email doesn't exist
     * ...the password is wrong
     */
    fun validateLoginInput(
        email: String,
        password: String
    ): Boolean {
        if(email.isEmpty() || password.isEmpty()){
            return false
        }

        if (existingAccounts.any { it.email == email }) {
            val account = existingAccounts.first { it.email == email }
            if (account.password == password) {
                return true
            }
        }

        return false
    }
}