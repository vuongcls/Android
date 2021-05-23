package com.example.droidcafekotlin


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity


class OderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var back: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oder)

        back = findViewById(R.id.button)
        val textView = findViewById<TextView>(R.id.order_textview)
        textView.text = intent.getStringExtra("check")

        Back()

        val spinner = findViewById<Spinner>(R.id.label_spinner)
        if (spinner != null) {
            spinner.onItemSelectedListener = this
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.labels_array, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
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

    override fun onItemSelected(
        adapterView: AdapterView<*>,
        view: View?, i: Int, l: Long
    ) {
        val spinnerLabel = adapterView.getItemAtPosition(i).toString()
        displayToast(spinnerLabel)
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {
    }
}