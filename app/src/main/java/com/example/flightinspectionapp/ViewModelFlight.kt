package com.example.flightinspectionapp

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.Observable.OnPropertyChangedCallback
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelFlight : ViewModel(), Observable {
    private val modelFlight: ModelFlight = ModelFlight()

    @Bindable
    val port = MutableLiveData<String>()

    val _ipServer = MutableLiveData<String>()

    fun connect() {
        modelFlight.connectToFlight(_ipServer.value.toString(), port.value.toString().toInt())
    }

    private var rudder = 50

    @Bindable
    fun getRudder(): Int {
        return rudder
    }

    fun setRudder(speed: Int) {
        rudder = speed
        changeRudder((speed.toFloat() - 50) / 100)
    }

    private var throttle = 0

    @Bindable
    fun getThrottle(): Int {
        return throttle
    }

    fun setThrottle(speed: Int) {
        throttle = speed
        changeThrottle((speed.toFloat()) / 100)
    }

    fun changeAileron(x: Float) {
        modelFlight.setAileron(x)
    }

    fun changeElevator(x: Float) {
        modelFlight.setElevator(x)
    }

    fun changeRudder(x: Float) {
        modelFlight.setRudder(x)
    }

    fun changeThrottle(x: Float) {
        modelFlight.setThrottle(x)
    }

    override fun addOnPropertyChangedCallback(callback: OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: OnPropertyChangedCallback?) {

    }
}