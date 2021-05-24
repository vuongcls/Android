package com.example.pickerfortime

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c[Calendar.HOUR_OF_DAY]
        val minute = c[Calendar.MINUTE]

        return TimePickerDialog(
            requireActivity(), this, hour, minute, android.text.format.DateFormat.is24HourFormat(requireActivity())
        )
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val activity = activity as MainActivity?
        activity?.processTimePickerResult(hourOfDay, minute)
    }
}