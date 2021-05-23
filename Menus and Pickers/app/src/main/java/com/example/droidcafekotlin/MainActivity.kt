package com.example.droidcafekotlin

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private var mOrderMessage = ""
    private var transfer: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transfer = findViewById(R.id.cart)

        getTransfer()
    }

    fun displayToast(message: String?) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun showDonutOrder(view: View) {
        mOrderMessage = getString(R.string.donut_order_message)
        displayToast(mOrderMessage)
    }

    fun showIceCreamOrder(view: View) {
        mOrderMessage = getString(R.string.ice_cream_order_message)
        displayToast(mOrderMessage)
    }

    fun showFroyoOrder(view: View) {
        mOrderMessage = getString(R.string.froyo_order_message)
        displayToast(mOrderMessage)
    }

    private fun getTransfer() {
        transfer!!.setOnClickListener {
            val intent = Intent(application, OderActivity::class.java)
            if (mOrderMessage.equals("")) {
                intent.putExtra("check", "Please order!")
                startActivity(intent)
            } else {
                intent.putExtra("check", mOrderMessage)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_order -> {
                val intent = Intent(this, OderActivity::class.java)
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage)
                startActivity(intent)
                return true
            }
            R.id.action_status -> {
                displayToast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                displayToast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                displayToast(getString(R.string.action_contact_message))
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}