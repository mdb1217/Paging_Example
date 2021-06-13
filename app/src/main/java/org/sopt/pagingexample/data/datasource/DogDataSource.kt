package org.sopt.pagingexample.data.datasource

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.sopt.pagingexample.data.remote.model.ResDogImgList

interface DogDataSource {
    fun getDog(path : String): Flow<PagingData<String>>
}