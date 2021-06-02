package org.sopt.pagingexample

import android.app.Application
import org.sopt.pagingexample.di.setUpKoin

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin(
            this
        )
    }
}