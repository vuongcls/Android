package com.example.navdrawerexperiment

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (view != null) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
                }
            }
        })
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer?.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView?.setNavigationItemSelectedListener(this)
    }


    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        return when (item.getItemId()) {
            R.id.nav_camera -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_camera))
                true
            }
            R.id.nav_gallery -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_gallery))
                true
            }
            R.id.nav_slideshow -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_slideshow))
                true
            }
            R.id.nav_manage -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_tools))
                true
            }
            R.id.nav_share -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_share))
                true
            }
            R.id.nav_send -> {
                drawer.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_send))
                true
            }
            else -> false
        }
    }

    fun displayToast(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}