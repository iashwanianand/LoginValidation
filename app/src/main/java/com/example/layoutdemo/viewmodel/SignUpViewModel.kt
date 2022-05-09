package com.example.layoutdemo.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.layoutdemo.view.LoginActivity

class SignUpViewModel(application: Application): AndroidViewModel(application) {
    var mContext = application

    var fullName :ObservableField<String> = ObservableField("")
    var email :ObservableField<String> = ObservableField("")
    var password :ObservableField<String> = ObservableField("")
    
    /*var fullName : ObservableField<String>? = null
    var email : ObservableField<String>? = null
    var password : ObservableField<String>? = null*/
    

    fun fullNameValidation(): Boolean {
        if (fullName.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your Full Name", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    private fun emailValidation(): Boolean {
        if (email.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your Email ID", Toast.LENGTH_SHORT).show()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.get().toString()).matches()) {
            Toast.makeText(mContext, "Enter a valid Email ID", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    private fun passwordValidation(): Boolean {
        if (password.get().toString().isBlank()) {
            Toast.makeText(mContext, "Enter your password", Toast.LENGTH_SHORT).show()
            return false
        } else if (password.get().toString().length < 8) {
            Toast.makeText(mContext, "Password must be of 8 character", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }

    fun signupButton() {
        if (fullNameValidation() && emailValidation() && passwordValidation()) {
            Toast.makeText(mContext, "Registered Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(mContext, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            mContext.startActivity(intent)

        }
    }
}