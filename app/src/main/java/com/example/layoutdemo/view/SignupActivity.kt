package com.example.layoutdemo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.layoutdemo.R
import com.example.layoutdemo.databinding.ActivitySignupBinding
import com.example.layoutdemo.viewmodel.SignUpViewModel

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

       /* binding.tvLogin.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }*/

       /* binding.backArrow.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }*/

    }

    override fun onBackPressed() {
       /* intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()*/
    }
}