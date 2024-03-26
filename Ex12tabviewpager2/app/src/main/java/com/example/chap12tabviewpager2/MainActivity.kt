package com.example.chap12tabviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chap12tabviewpager2.adapter.MyFragmentStateAdapter
import com.example.chap12tabviewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // ViewPager2 위젯 가져오기
        val viewPager = binding.viewpager

        // MyFragmentStateAdapter를 사용하여 어댑터 초기화
        val adapter = MyFragmentStateAdapter(this)

        // ViewPager2에 어댑터 설정
        viewPager.adapter = adapter

        // TabLayoutMediator를 사용하여 TabLayout과 ViewPager2 연결 (선택적)
        val tabLayout = binding.tabs
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}