package com.example.pickerfordate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePicker(view: View?) {
        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(
            supportFragmentManager,
            getString(R.string.datepicker)
        )
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val month_string = Integer.toString(month + 1)
        val day_string = Integer.toString(day)
        val year_string = Integer.toString(year)
        val dateMessage = month_string +
                "/" + day_string +
                "/" + year_string
        Toast.makeText(
            this, getString(R.string.date) + dateMessage,
            Toast.LENGTH_SHORT
        ).show()
    }
}