package com.example.tabexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL


        val viewPager = findViewById<ViewPager>(R.id.pager)
        val adapter = PagerAdapter(
            supportFragmentManager, tabLayout.tabCount
        )
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(
            object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
    }
}