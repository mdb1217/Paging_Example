package org.sopt.pagingexample.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface DogRepository {
    fun getDog(path : String): Flow<PagingData<String>>
}