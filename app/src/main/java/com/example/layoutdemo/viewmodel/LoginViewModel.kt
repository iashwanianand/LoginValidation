package com.example.layoutdemo.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.layoutdemo.base.BaseViewModel
import com.example.layoutdemo.view.DashboardActivity
import com.example.layoutdemo.view.SignupActivity

class LoginViewModel(application: Application) : BaseViewModel(application) {
    private val mContext = application

    /*var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null*/

    var email: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")

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

    fun loginButton() {
        if (emailValidation() && passwordValidation()) {
            mContext.startActivity(
                Intent(
                    mContext,
                    DashboardActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
            Toast.makeText(mContext, "Login Success", Toast.LENGTH_SHORT).show()
            email.set("")
            password.set("")
        }
    }

    fun signupButton() {
        mContext.startActivity(
            Intent(
                mContext,
                SignupActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
        )

    }
}