package org.sopt.pagingexample.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.sopt.pagingexample.data.pagingsource.SamplePagingSource
import org.sopt.pagingexample.data.remote.api.DogService
import org.sopt.pagingexample.data.remote.model.ResDogImgList

class RemoteDogDataSource(private val service: DogService) : DogDataSource {
    override fun getDog(path : String): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SamplePagingSource(service, path)
            }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 25
    }
}