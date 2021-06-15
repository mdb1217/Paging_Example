package org.sopt.pagingexample.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.sopt.pagingexample.presentation.viewmodel.MainViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}