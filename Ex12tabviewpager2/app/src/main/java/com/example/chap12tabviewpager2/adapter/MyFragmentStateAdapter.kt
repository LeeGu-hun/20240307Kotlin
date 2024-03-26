package com.example.chap12tabviewpager2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chap12tabviewpager2.OneFragment
import com.example.chap12tabviewpager2.ThreeFragment
import com.example.chap12tabviewpager2.TwoFragment

// Adapter는 데이터를 RecyclerView에 주입하는 객체
class MyFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val fragments: List<Fragment>

    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}