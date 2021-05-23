package com.example.contextmenuscrollingtext

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val article_text: TextView = findViewById(R.id.article)
        registerForContextMenu(article_text)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_edit -> {
                displayToast(getString(R.string.edit_message))
                true
            }
            R.id.context_share -> {
                displayToast(getString(R.string.share_message))
                true
            }
            R.id.context_delete -> {
                displayToast(getString(R.string.delete_message))
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }
}