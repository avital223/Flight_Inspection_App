package com.example.flightinspectionapp

import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class ModelFlight {
    private val dispatchQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()
    private val socket = Socket("192.168.1.1", 6400)
    private val out = PrintWriter(socket.getOutputStream(), true)

    init{
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

    fun setAileron(v: Float) {
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/aileron $v\r\n")
            out.flush()
        })

    }

    fun setElevator(v: Float) {
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/elevator $v\r\n")
            out.flush()
        })
    }

    fun setRudder(v: Float) {
        dispatchQueue.put(Runnable {
            out.print("set /controls/flight/rudder $v\r\n")
            out.flush()
        })

    }

    fun setThrottle(v: Float) {
        dispatchQueue.put(Runnable {
            out.print("set /controls/engines/current-engine/throttle $v\r\n")
            out.flush()
        })
    }


}