package com.example.pickerfordate

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import android.app.Dialog
import java.util.Calendar

class DatePickerFragment : DialogFragment(),

    OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        val activity = activity as MainActivity?
        activity!!.processDatePickerResult(year, month, day)
    }
}