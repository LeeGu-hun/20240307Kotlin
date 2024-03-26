package com.example.chap12tabviewphager2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.chap12tabviewphager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMain.root)

        // viewPageAdpger 설정
        var viewpagerAdatper = FragmentViewPagerAdapter(this)
        bindMain.viewPager.adapter = viewpagerAdatper
        bindMain.viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback () {
            override fun onPageSelected(position: Int) {
                Log.i("onPageSelected", "page $position selected")
                super.onPageSelected(position)
            }
        })

        val tabLayout = bindMain.tabs

        //viewPage, TabLayout 연결
        TabLayoutMediator(tabLayout, bindMain.viewPager) { tab, position ->
            Log.i("TabLayoutMediator>>", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "TabA"
                1 -> tab.text = "TabB"
                2 -> tab.text = "TabC"
            }
        }.attach()
    }
}