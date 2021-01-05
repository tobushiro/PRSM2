package com.example.prsm2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter (fm:FragmentManager, private val context: Context): FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> { return Tab1Fragment()}
            else -> {return Tab2Fragment()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> {return  "お気に入り"}
            1 -> {return  "腫瘍"}
            2 -> {return  "難治性潰瘍"}
            3 -> {return  "内科"}
            else -> {return "tab_02"}
        }
    }
}