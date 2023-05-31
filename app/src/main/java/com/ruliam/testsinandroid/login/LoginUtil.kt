package com.ruliam.testsinandroid.login

import androidx.core.util.PatternsCompat

object LoginUtil {
    /**
     * The input is not valid if...
     * ...the local part length < 3
     */
    fun validateEmailInput(
        email: String
    ): Boolean {
        if(email.isEmpty()){
            return false
        }

        val parts = email.split("@")
        if (parts.size != 2 || parts[0].length < 3) {
            return false
        }

        if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            return false
        }
        return true
    }

    /**
     * The input is not valid if...
     * ...the password length < 6
     */
    fun validatePasswordInput(
        password: String
    ): Boolean {
        if(password.isEmpty()){
            return false
        }
        if(password.length < 6){
            return false
        }
        return true
    }


    /**
     * The input is not valid if...
     * ...the password are not the same
     */
    fun validateConfirmPasswordInput(
        password: String,
        confirmPassword: String
    ): Boolean {
        return password.contentEquals(confirmPassword)
    }

}