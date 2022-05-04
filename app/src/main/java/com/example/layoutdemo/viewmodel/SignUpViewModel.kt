package com.example.layoutdemo.viewmodel

import android.app.Application
import android.util.Patterns
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SignUpViewModel(application: Application): AndroidViewModel(application) {

    var fullName : ObservableField<String>? = null
    var email : ObservableField<String>? = null
    var password : ObservableField<String>? = null

    private val signUpResult = MutableLiveData<String>()

    fun signUpValidation() {
        if (fullName.toString().isBlank()) {
            signUpResult.value = "Enter your full name"
        } else if (email.toString().isBlank()) {
            signUpResult.value = "Enter your Email ID"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
            signUpResult.value = "Enter a valid Email ID"
        } else if (password.toString().isBlank()) {
            signUpResult.value = "Enter your password"
        } else if (password.toString().length < 8) {
            signUpResult.value = "Password must be of 8 character"
        } else {
            signUpResult.value = "Registered Successfully"

            
        }
    }
}