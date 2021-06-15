package org.sopt.pagingexample

import android.app.Application
import org.sopt.pagingexample.di.*

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin(
            this,
            networkModule,
            remoteDataSourceModule,
            repositoryModule,
            viewModelModule
        )
    }
}