package com.fsoft.tabexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fsoft.tabexperiment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setEvent()
    }

    private fun setEvent() {
        binding.pager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(
            object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    binding.pager.setCurrentItem(tab.position)
                }
                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
    }

    private fun init() {
        setSupportActionBar(binding.toolbar)

        binding.tabLayout.addTab(binding.tabLayout.newTab()
            .setText(getString(R.string.tab_label1)))
        binding.tabLayout.addTab(binding.tabLayout.newTab()
            .setText(getString(R.string.tab_label2)))
        binding.tabLayout.addTab(binding.tabLayout.newTab()
            .setText(getString(R.string.tab_label3)))
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        val adapter = PagerAdapter(supportFragmentManager, binding.tabLayout.tabCount)
        binding.pager.setAdapter(adapter)
    }
}