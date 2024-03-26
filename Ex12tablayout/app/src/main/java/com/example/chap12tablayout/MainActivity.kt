package com.example.chap12tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.chap12tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val tabLayout = binding.tabs

    //xml에 버튼을 정의하지 않고 동적으로 선언할 경우
//    val tab1: TabLayout.Tab = tabLayout.newTab()
//    tab1.text = "Tab1"
//    tabLayout.addTab(tab1)
//    val tab2: TabLayout.Tab = tabLayout.newTab()
//    tab2.text = "Tab2"
//    tabLayout.addTab(tab2)
//    val tab3: TabLayout.Tab = tabLayout.newTab()
//    tab3.text = "Tab3"
//    tabLayout.addTab(tab3)

    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
      override fun onTabSelected(tab: TabLayout.Tab?) {
        val transaction = supportFragmentManager.beginTransaction()
        Log.d(">>", tab?.text.toString())
        when (tab?.text) {
          "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
          "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
          "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
        }
        transaction.commit()
      }

      override fun onTabUnselected(tab: TabLayout.Tab?) {
        val transaction = supportFragmentManager.beginTransaction()
        Log.d(">>", tab?.text.toString())
        when (tab?.text) {
          "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
          "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
          "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
        }
        transaction.commit()
      }

      override fun onTabReselected(tab: TabLayout.Tab?) {
        val transaction = supportFragmentManager.beginTransaction()
        Log.d(">>", tab?.text.toString())
        when (tab?.text) {
          "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
          "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
          "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
        }
        transaction.commit()
      }
    })
    // 화면 시작할 때 보여줄 프래그먼트 지정
    supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()
  }
}