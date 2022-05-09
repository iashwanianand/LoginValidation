package com.example.layoutdemo.application

import android.app.Application

class Apps: Application() {

    companion object {
        lateinit var instance : Apps
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}