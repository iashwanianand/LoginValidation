package com.example.layoutdemo.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityLoginBinding
import com.example.layoutdemo.databinding.ActivitySignupBinding
import com.example.layoutdemo.viewmodel.LoginViewModel
import com.example.layoutdemo.viewmodel.SignUpViewModel

class SignupActivity : BaseActivity<ActivitySignupBinding, SignUpViewModel>() {

    private lateinit var mViewBinding: ActivitySignupBinding
    private lateinit var mSignupViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewDataBinding()
        mViewBinding.signupViewModel = mSignupViewModel

    }

    override fun onBackPressed() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getBindingVariable(): Int {
        return BR.signupViewModel
    }

    override fun getViewModel(): SignUpViewModel {
        val mSignUpViewModel: SignUpViewModel by viewModels()
        this.mSignupViewModel = mSignUpViewModel
        return mSignUpViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_signup
    }
}