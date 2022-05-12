package com.example.loginvalidation.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.example.loginvalidation.base.BaseViewModel
import com.example.loginvalidation.roomdb.Person
import com.example.loginvalidation.roomdb.PersonRepository
import com.example.loginvalidation.view.LoginActivity
import kotlinx.coroutines.launch

class SignUpViewModel(application: Application) : BaseViewModel(application) {
    private val mContext = application

    var fullName: ObservableField<String> = ObservableField("")
    var email: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")

    /*var fullName : ObservableField<String>? = null
    var email : ObservableField<String>? = null
    var password : ObservableField<String>? = null*/

    // Format validation of Full Name
    private fun fullNameValidation(): Boolean {
        if (fullName.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your Full Name", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }

    // Format validation of Email
    private fun emailValidation(): Boolean {
        if (email.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your Email ID", Toast.LENGTH_SHORT).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.get().toString()).matches()) {
            Toast.makeText(mContext, "Enter a valid Email ID", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }

    // Format validation of Password
    private fun passwordValidation(): Boolean {
        if (password.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your password", Toast.LENGTH_SHORT).show()
        } else if (password.get().toString().length < 8) {
            Toast.makeText(mContext, "Password must be of 8 character", Toast.LENGTH_SHORT).show()
        } else {
            return true
        }
        return false
    }

    // Signup button function
    fun signupButton() {
        if (fullNameValidation() && emailValidation() && passwordValidation()) {
            mContext.startActivity(
                Intent(
                    mContext,
                    LoginActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
            Toast.makeText(mContext, "Registered Successfully", Toast.LENGTH_SHORT).show()
            fullName.set("")
            email.set("")
            password.set("")
        }
    }

    // Login button Function
    fun loginButton() {
        mContext.startActivity(
            Intent(
                mContext,
                LoginActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
        )
    }
}