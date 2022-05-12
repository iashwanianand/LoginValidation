package com.example.loginvalidation.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.loginvalidation.BR
import com.example.loginvalidation.R
import com.example.loginvalidation.base.BaseActivity
import com.example.loginvalidation.databinding.ActivityDashboardBinding
import com.example.loginvalidation.viewmodel.DashboardViewModel

class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardViewModel>() {
    private lateinit var mViewBinding: ActivityDashboardBinding
    private lateinit var mViewModel: DashboardViewModel
    /*private var doubleBackToExitPressedOnce = false*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewDataBinding()
        mViewBinding.dashboardViewModel = mViewModel

    }

    override fun getBindingVariable(): Int {
        return BR.dashboardViewModel
    }

    override fun getViewModel(): DashboardViewModel {
        val mDashboardViewModel: DashboardViewModel by viewModels()
        this.mViewModel = mDashboardViewModel
        return mDashboardViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dashboard
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Press Logout to exit", Toast.LENGTH_SHORT).show()

        /* if (doubleBackToExitPressedOnce) {
             super.onBackPressed()
             return
         }
 
         this.doubleBackToExitPressedOnce = true
         Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
 
         Handler(Looper.getMainLooper()).postDelayed(Runnable {
             doubleBackToExitPressedOnce = false
         }, 2000)*/
    }
}