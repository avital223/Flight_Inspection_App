package com.example.flightinspectionapp

import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class ModelFlight {
    private val dispatchQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()
    private val socket = MutableLiveData<Socket>()
    private val out = MutableLiveData<PrintWriter>()
    private val _ip = MutableLiveData<String>()
    private val _port = MutableLiveData<Int>()

    init {
        Thread {
            while (true) {
                try {
                    dispatchQueue.take().run()
                } catch (e: InterruptedException) {
//                    dispatchQueue
                }
            }
        }.start()
    }

    fun connectToFlight(ip: String, port: Int) {
        dispatchQueue.put(Runnable {
            try {
                if (_ip.value != ip && _port.value != port) {
                    socket.postValue(Socket(ip, port))
                    if (socket.value?.isConnected == true) {
                        println("connected")
                        out.postValue(PrintWriter(socket.value!!.getOutputStream(), true))
                        _ip.postValue(ip)
                        _port.postValue(port)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
    }

    fun setAileron(v: Float) {
        dispatchQueue.put(Runnable {
            out.value?.print("set /controls/flight/aileron $v\r\n")
            out.value?.flush()
        })

    }

    fun setElevator(v: Float) {
        dispatchQueue.put(Runnable {
            out.value?.print("set /controls/flight/elevator $v\r\n")
            out.value?.flush()
        })
    }

    fun setRudder(v: Float) {
        dispatchQueue.put(Runnable {
            out.value?.print("set /controls/flight/rudder $v\r\n")
            out.value?.flush()
        })

    }

    fun setThrottle(v: Float) {
        dispatchQueue.put(Runnable {
            out.value?.print("set /controls/engines/current-engine/throttle $v\r\n")
            out.value?.flush()
        })
    }


}