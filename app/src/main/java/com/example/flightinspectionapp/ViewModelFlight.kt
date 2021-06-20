package com.example.flightinspectionapp

import androidx.lifecycle.ViewModel


class ViewModelFlight : ViewModel() {
    private val modelFlight : ModelFlight = ModelFlight()
    fun onChangeData() {
        for (i in 100 downTo -100 step 1) {
            modelFlight.setAileron((i / 100).toFloat())
            modelFlight.setElevator((i / 100).toFloat())
            modelFlight.setRudder((i / 100).toFloat())
//            modelFlight.setThrottle((i / 100).toFloat())
        }
    }
}