package org.sopt.pagingexample.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.sopt.pagingexample.data.datasource.DogDataSource

class DogRepositoryImpl(private val dogDataSource: DogDataSource) : DogRepository {
    override fun getDog(path: String): Flow<PagingData<String>> = dogDataSource.getDog(path)
}