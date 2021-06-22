package com.example.flightinspectionapp


import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.flightinspectionapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val joystick: Joystick = Joystick()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = ViewModelProvider(this).get(ViewModelFlight::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = mainViewModel
        }

        joystick.service?.value = object : Service {
            override fun onChange(x: Float, y: Float) {
                mainViewModel.changeAileron(x)
                mainViewModel.changeElevator(y)
            }
        }
        seekBar1.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mainViewModel.changeRudder((progress.toFloat() - 50) / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(
                    this@MainActivity,
                    "Discrete Seekbar current progress",
                    Toast.LENGTH_SHORT
                ).show()
                //write custom code to on start progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

    }
}