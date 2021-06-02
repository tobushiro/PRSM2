package com.example.prsm2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter (fm:FragmentManager, private val context: Context): FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return 8
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> { return Tab1Fragment("9000000")}//お気に入り
            1 -> { return Tab1Fragment("9100000")}//基本手技
            2 -> { return Tab1Fragment("9110000")}//感染
            3 -> { return Tab1Fragment("9130000")}//腫瘍
            4 -> { return Tab1Fragment("9160000")}//外傷
            else -> {return Tab2Fragment("mKey")}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> {return  "お気に入り"}
            1 -> {return  "基本手技"}
            2 -> {return  "感染"}
            3 -> {return  "腫瘍"}
            4 -> {return  "熱傷"}
            else -> {return "tab_02"}
        }
    }


}