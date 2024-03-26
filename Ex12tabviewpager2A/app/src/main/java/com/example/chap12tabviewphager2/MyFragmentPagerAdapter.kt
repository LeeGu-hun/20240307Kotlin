package com.example.chap12tabviewphager2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chap12tablayout.OneFragment
import com.example.chap12tablayout.ThreeFragment
import com.example.chap12tablayout.TwoFragment

class FragmentViewPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
    val fragments :List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}