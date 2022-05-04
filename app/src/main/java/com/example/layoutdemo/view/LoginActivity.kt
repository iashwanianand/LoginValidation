package com.example.layoutdemo.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityLoginBinding
import com.example.layoutdemo.viewmodel.LoginViewModel

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

//        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#146775")))

        /*binding.btnLogin.setOnClickListener {
                Log.d("TAG", "onCreate: Line 31")

                when {
                    binding.etEmail.text.isNullOrEmpty() ->
                        Toast.makeText(applicationContext, "Enter your Email Id", Toast.LENGTH_SHORT).show()

                        !Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches() ->
                        Toast.makeText(applicationContext, "Enter a valid Email Id", Toast.LENGTH_SHORT).show()

                    binding.etPassword.text.isNullOrEmpty() ->
                        Toast.makeText(applicationContext,"Enter your Password",Toast.LENGTH_SHORT).show()

                    binding.etPassword.text.toString().length < 8 ->
                        Toast.makeText(applicationContext,"Password must be of 8 character",Toast.LENGTH_SHORT).show()

                    else -> {
                        Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                        intent = Intent(this, DashboardActivity::class.java)
                        val email = binding.etEmail.text.toString()
                        val password = binding.etPassword.text.toString()
                        intent.putExtra("email", email)
                        intent.putExtra("password", password)
                        startActivity(intent)
                    }
                }
            }*/



        binding.tvSignup.setOnClickListener {
            intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun loginValidation() {
        if (viewModel.performValidation()) {
            intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed( {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}