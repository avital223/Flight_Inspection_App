package com.example.flightinspectionapp

import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.Observable.OnPropertyChangedCallback
import androidx.databinding.ObservableField
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