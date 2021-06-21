package com.example.flightinspectionapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.flightinspectionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(R.layout.activity_main)
//
        val mainViewModel = ViewModelProvider(this).get(ViewModelFlight::class.java)
//        databinding.viewmodel = mainViewModel
//        databinding.lifecycleOwner = this

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
        }

    }
}