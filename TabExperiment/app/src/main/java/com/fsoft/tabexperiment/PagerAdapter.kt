package com.fsoft.tabexperiment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager, numOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    private var mNumOfTabs: Int = 0

//    constructor(fm: FragmentManager, numOfTabs: Int){
//        this.mNumOfTabs = numOfTabs
//    }


    override fun getCount(): Int = mNumOfTabs

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            else -> Fragment()
        }
    }
}