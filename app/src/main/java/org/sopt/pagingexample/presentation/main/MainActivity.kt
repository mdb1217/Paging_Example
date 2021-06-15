package org.sopt.pagingexample.presentation.main

import android.view.MenuItem
import androidx.activity.viewModels
import org.sopt.pagingexample.R
import org.sopt.pagingexample.databinding.ActivityMainBinding
import org.sopt.pagingexample.presentation.base.BaseActivity
import org.sopt.pagingexample.presentation.local.LocalFragment
import org.sopt.pagingexample.presentation.main.adapter.MainViewPagerAdapter
import org.sopt.pagingexample.presentation.search.SearchFragment
import org.sopt.pagingexample.presentation.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun initView() {
        initMainViewPager()
        initMainBottomNavigation()
    }

    private fun initMainViewPager() {
        val mainViewPagerAdapter = MainViewPagerAdapter(this@MainActivity)
        with (mainViewPagerAdapter) {
            fragmentList = listOf(SearchFragment(), LocalFragment())

            binding.vpMain.adapter = this
        }
    }

    private fun whichNavigationItemSelected(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_search -> binding.vpMain.currentItem = 0
            R.id.menu_local -> binding.vpMain.currentItem = 1
        }
    }

    private fun initMainBottomNavigation() {
        binding.bnvMain.setOnNavigationItemSelectedListener {
            whichNavigationItemSelected(it)
            true
        }
    }
}