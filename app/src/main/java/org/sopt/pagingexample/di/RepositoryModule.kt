package org.sopt.pagingexample.di

import org.koin.dsl.module
import org.sopt.pagingexample.data.repository.DogRepository
import org.sopt.pagingexample.data.repository.DogRepositoryImpl

val repositoryModule = module {
    single<DogRepository> { DogRepositoryImpl(get()) }
}
