package com.example.keyboarddialphone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.phone_text)
        editText?.setOnEditorActionListener { textView, actionId, keyEvent ->

            var handled = false

            if (actionId == EditorInfo.IME_ACTION_SEND) {
                dialNumber()
                handled = true
            }
            handled
        }
    }

    private fun dialNumber() {
        val editText = findViewById<EditText>(R.id.phone_text)
        var phoneNum: String? = null

        if (editText != null) phoneNum = "tel:" + editText.text.toString()

        Log.d(TAG, "dialNumber: $phoneNum")

        val intent = Intent(Intent.ACTION_DIAL)

        intent.data = Uri.parse(phoneNum)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(TAG, "ImplicitIntents: Can't handle this!")
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
