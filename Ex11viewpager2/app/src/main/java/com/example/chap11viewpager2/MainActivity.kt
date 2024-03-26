package com.example.chap11viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chap11viewpager2.adapter.MyFragmentStateAdapter
import com.example.chap11viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val adapter = MyFragmentStateAdapter(this)
    binding.viewpager.adapter = adapter
  }
}