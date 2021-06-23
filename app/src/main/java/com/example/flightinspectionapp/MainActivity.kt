package com.example.flightinspectionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.flightinspectionapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var joystick: Joystick
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = ViewModelProvider(this).get(ViewModelFlight::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
            joystick = Joystick(object : Service {
                override fun onChange(x: Float, y: Float) {
                    mainViewModel.changeAileron(x)
                    mainViewModel.changeElevator(y)
                }
            })
        }
        joyStick.setOnTouchListener(joystick)
    }
}