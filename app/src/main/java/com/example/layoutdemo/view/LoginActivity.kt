package com.example.layoutdemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityLoginBinding
import com.example.layoutdemo.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    private lateinit var mViewBinding: ActivityLoginBinding
    private lateinit var mLoginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewDataBinding()
        mViewBinding.loginViewModel = mLoginViewModel

    }

    override fun getBindingVariable(): Int {
        return BR.loginViewModel
    }

    override fun getViewModel(): LoginViewModel {
        val mLoginViewModel: LoginViewModel by viewModels()
        this.mLoginViewModel = mLoginViewModel
        return mLoginViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun onBackPressed() {
        TODO()
    }
}
