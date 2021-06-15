package org.sopt.pagingexample.presentation.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.sopt.pagingexample.presentation.main.MainActivity

class MainViewPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}