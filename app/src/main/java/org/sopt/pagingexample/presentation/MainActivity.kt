package org.sopt.pagingexample.presentation

import androidx.activity.viewModels
import org.sopt.pagingexample.R
import org.sopt.pagingexample.databinding.ActivityMainBinding
import org.sopt.pagingexample.presentation.base.BaseActivity
import org.sopt.pagingexample.presentation.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()


}