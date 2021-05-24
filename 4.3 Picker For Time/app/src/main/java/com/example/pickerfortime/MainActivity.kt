package com.example.pickerfortime

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.pickerfortime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()

    }

    private fun setEvent() {
        binding.button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                clickButton()
            }
        })
    }

    private fun clickButton() {
        val newFragment: DialogFragment = TimePickerFragment()
        newFragment.show(
            supportFragmentManager, getString(R.string.timepicker)
        )
    }

    fun processTimePickerResult(hourOfDay: Int, minute: Int) {
        val hourStr = Integer.toString(hourOfDay)
        val minuteStr = Integer.toString(minute)
        val time = "$hourStr:$minuteStr"
        Toast.makeText(this, getString(R.string.time_toast) + time, Toast.LENGTH_SHORT)
            .show()
    }
}