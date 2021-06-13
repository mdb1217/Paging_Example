package org.sopt.pagingexample.di

import org.koin.dsl.module
import org.sopt.pagingexample.data.datasource.DogDataSource
import org.sopt.pagingexample.data.datasource.RemoteDogDataSource

val remoteDataSourceModule = module {
    single<DogDataSource> { RemoteDogDataSource(get()) }
}