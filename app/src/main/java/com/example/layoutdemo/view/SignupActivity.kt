package com.example.layoutdemo.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivitySignupBinding
import com.example.layoutdemo.viewmodel.SignUpViewModel

class SignupActivity : BaseActivity<ActivitySignupBinding, SignUpViewModel>() {

    private lateinit var mViewBinding: ActivitySignupBinding
    private lateinit var mViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewDataBinding()
        mViewBinding.signupViewModel = mViewModel

    }

    override fun getBindingVariable(): Int {
        return BR.signupViewModel
    }

    override fun getViewModel(): SignUpViewModel {
        val mSignUpViewModel: SignUpViewModel by viewModels()
        this.mViewModel = mSignUpViewModel
        return mSignUpViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_signup
    }

    override fun onBackPressed() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}