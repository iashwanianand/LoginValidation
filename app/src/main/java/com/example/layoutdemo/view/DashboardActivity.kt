package com.example.layoutdemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityDashboardBinding
import com.example.layoutdemo.viewmodel.DashboardViewModel

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