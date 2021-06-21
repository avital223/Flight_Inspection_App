package com.example.flightinspectionapp

import androidx.databinding.Bindable
import androidx.databinding.Observable
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

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
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
}