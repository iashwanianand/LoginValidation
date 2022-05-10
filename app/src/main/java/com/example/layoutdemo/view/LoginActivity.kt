package com.example.layoutdemo.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityLoginBinding
import com.example.layoutdemo.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    private lateinit var mViewBinding: ActivityLoginBinding
    private lateinit var mViewModel: LoginViewModel
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewDataBinding()
        mViewBinding.loginViewModel = mViewModel

    }

    override fun getBindingVariable(): Int {
        return BR.loginViewModel
    }

    override fun getViewModel(): LoginViewModel {
        val mLoginViewModel: LoginViewModel by viewModels()
        this.mViewModel = mLoginViewModel
        return mLoginViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}
