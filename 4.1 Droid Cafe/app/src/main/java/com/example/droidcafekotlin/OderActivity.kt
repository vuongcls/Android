package com.example.droidcafekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

    private fun Back() {
        back!!.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}