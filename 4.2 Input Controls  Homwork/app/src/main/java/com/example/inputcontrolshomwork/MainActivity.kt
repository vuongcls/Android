package com.example.inputcontrolshomwork

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var btnToast: Button? = null
    private var message = "Add: "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast = findViewById(R.id.button_toast)
        toastMessage()
    }

    private fun toastMessage() {
        btnToast!!.setOnClickListener {
            selectToppings(
                findViewById<View>(R.id.checkBox1) as CheckBox,
                getString(R.string.syrup)
            )
            selectToppings(
                findViewById<View>(R.id.checkBox2) as CheckBox,
                getString(R.string.sprinkles)
            )
            selectToppings(
                findViewById<View>(R.id.checkBox3) as CheckBox,
                getString(R.string.crushed_nuts)
            )
            selectToppings(
                findViewById<View>(R.id.checkBox4) as CheckBox,
                getString(R.string.cherries)
            )
            selectToppings(
                findViewById<View>(R.id.checkBox5) as CheckBox,
                getString(R.string.oreo)
            )
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectToppings(checkBox: CheckBox, topping: String) {
        if (checkBox.isChecked) {
            if (!message.contains(topping)) {
                message = "$message $topping"
            }
        } else {
            if (message.contains(topping)) {
                message = message.replace(" $topping", "")
            }
        }
    }
}