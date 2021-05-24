package com.example.dialogforalert

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickShowAlert(view: View?) {
        val myAlertBuilder = AlertDialog.Builder(this)

        myAlertBuilder.setTitle("Alert")
        myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:")

        myAlertBuilder.setPositiveButton("OK",
            DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Pressed OK",
                    Toast.LENGTH_SHORT
                ).show()
            })
        myAlertBuilder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Pressed Cancel",
                    Toast.LENGTH_SHORT
                ).show()
            })

        myAlertBuilder.show()
    }
}