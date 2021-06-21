package com.example.flightinspectionapp

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelFlight : ViewModel(), Observable {
    private val modelFlight: ModelFlight = ModelFlight()
    fun onChangeData() {
        for (i in 100 downTo -100 step 1) {
            modelFlight.setAileron((i / 100).toFloat())
            modelFlight.setElevator((i / 100).toFloat())
            modelFlight.setRudder((i / 100).toFloat())
//            modelFlight.setThrottle((i / 100).toFloat())
        }
    }

    @Bindable
    val port = MutableLiveData<String>()

    //    @Bindable
    val _ipServer = MutableLiveData<String>()

    fun connect() {
        print("Ip: $_ipServer Port: $port")
        modelFlight.connectToFlight(_ipServer.value.toString(), port.value.toString().toInt())
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}