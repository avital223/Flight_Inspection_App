package com.example.flightinspectionapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val mainViewModel = ViewModelProvider(this).get(ViewModelFlight::class.java)
//        DataBindingUtil.setContentView<ActivityMainBinding>(
//            this, R.layout.activity_main
//        ).apply {
//            this.setLifecycleOwner(this@MainActivity)
//            this.viewmodel = mainViewModel
//        }

    }
}