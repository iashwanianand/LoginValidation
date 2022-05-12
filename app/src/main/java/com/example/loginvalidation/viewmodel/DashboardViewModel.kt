package com.example.loginvalidation.viewmodel

import android.app.Application
import android.content.Intent
import android.widget.Toast
import com.example.loginvalidation.base.BaseViewModel
import com.example.loginvalidation.view.LoginActivity

class DashboardViewModel(application: Application) : BaseViewModel(application) {
    private val mContext = application

    fun logoutButton() {
        Toast.makeText(mContext, "Logout Successfully", Toast.LENGTH_SHORT).show()
        mContext.startActivity(
            Intent(
                mContext,
                LoginActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)
        )
    }
}