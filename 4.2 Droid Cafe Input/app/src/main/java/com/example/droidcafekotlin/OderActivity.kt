package com.example.droidcafekotlin


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OderActivity : AppCompatActivity() {
    private var back: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oder)

        back = findViewById(R.id.button)
        val textView = findViewById<TextView>(R.id.order_textview)
        textView.text = intent.getStringExtra("check")

        Back()
    }

    fun displayToast(message: String?) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun Back() {
        back!!.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked

        when (view.getId()) {
            R.id.sameday -> if (checked)
                displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked)
                displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked)
                displayToast(getString(R.string.pick_up))
            else -> {
            }
        }
    }
}