package com.example.flightinspectionapp

import android.view.MotionEvent
import android.view.View
import kotlin.math.*

class Joystick(_s: Service) : View.OnTouchListener {
    public var service: Service = _s
    var x = 0f
    var y = 0f
    var start_x = -1f
    var start_y = -1f

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                if (view != null) {
                    x = view.x - event.rawX
                    y = view.y - event.rawY
                    if (start_x == -1f) {
                        start_x = view.x
                        start_y = view.y
                    }
                }
            }
            MotionEvent.ACTION_MOVE -> {
                var _x = (event.rawX + x - start_x) / (start_x)
                var _y = (event.rawY + y - start_y) / (start_y) * -1
                if (checkInCircle(_x, _y)) {
                    view?.animate()?.x(event.rawX + x)?.y(event.rawY + y)
                        ?.setDuration(0)?.start()
                    service.onChange(_x, _y)
                    println(_y)
                } else {
                    val alpha = atan(_y / _x)
                    _x = cos(alpha) * sign(_x)
                    _y = sin(alpha) * sign(_x)
                    view?.animate()?.x(_x * start_x + start_x)?.y(_y * -1 * start_y + start_y)
                        ?.setDuration(0)?.start()
                    service.onChange(_x, _y)
                    println(_y)
                }

            }
            MotionEvent.ACTION_UP -> {
                // if you want to get the joystick back to the center
                view?.animate()?.x(start_x)?.y(start_y)
                    ?.setDuration(500)?.start()
                service.onChange(0f, 0f)
            }
            else -> return false
        }
        return true
    }

    // x^2 + y^2 < r^2
    fun checkInCircle(x: Float, y: Float): Boolean {
        return x * x + y * y < 1
    }


}