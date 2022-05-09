package com.example.layoutdemo.view

import android.os.Bundle
import androidx.activity.viewModels
import com.example.layoutdemo.BR
import com.example.layoutdemo.R
import com.example.layoutdemo.base.BaseActivity
import com.example.layoutdemo.databinding.ActivityDashboardBinding
import com.example.layoutdemo.viewmodel.DashboardViewModel
import com.example.layoutdemo.viewmodel.LoginViewModel

class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardViewModel>() {
    private lateinit var mViewBinding: ActivityDashboardBinding
    private lateinit var mDashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun getBindingVariable(): Int {
        return BR.dashboardViewModel
    }

    override fun getViewModel(): DashboardViewModel {
        val mDashboardViewModel: DashboardViewModel by viewModels()
        this.mDashboardViewModel = mDashboardViewModel
        return mDashboardViewModel

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dashboard
    }
}