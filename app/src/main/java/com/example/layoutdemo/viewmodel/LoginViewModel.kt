package com.example.layoutdemo.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var flag: Boolean = false

    /*var emailAddress = MutableLiveData<String>()
    var emailAddress: ObservableField<String>? = null
    var password = MutableLiveData<String>()*/

    var email: String = ""
    var password: String = ""

    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    private fun emailValidation(): Boolean {
        if (email.isBlank()) {
            logInResult.value = "Enter your Email ID"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            logInResult.value = "Enter a valid Email ID"
        }
        return true
    }

    private fun passwordValidation(): Boolean {
        if (password.isBlank()) {
            logInResult.value = "Enter your Password"
        } else if (password < 8.toString()) {
            logInResult.value = "Password must be of 8 character"
        }
        return true
    }

    fun performValidation(): Boolean {
        if (!emailValidation() && !passwordValidation()) {
            return false
        }
        return true
    }
}