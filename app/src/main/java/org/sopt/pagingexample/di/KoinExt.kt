package org.sopt.pagingexample.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun setUpKoin(
    context : Context,
    vararg module : Module
) {
    startKoin {
        androidLogger()
        androidContext(context)
        modules(*module)
    }
}