package org.sopt.pagingexample.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.sopt.pagingexample.data.remote.api.DogService
import org.sopt.pagingexample.data.remote.model.ResDogImgList
import retrofit2.HttpException
import java.io.IOException
import org.sopt.pagingexample.data.datasource.RemoteDogDataSource.Companion.NETWORK_PAGE_SIZE


class SamplePagingSource(private val dogService: DogService, private val query: String) : PagingSource<Int, String>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, String> {
        val pageIndex = params.key ?: DB_STARTING_PAGE_INDEX
        return try {
            // key가 정의되지 않았다면 첫번째 페이지에서 시작한다
            val nextPageNumber = params.key ?: 1
            val response = dogService.getFollower(query, pageIndex)
            val dogImgList = response.message
            val nextKey =
                if (dogImgList.isEmpty()) {
                    null
                } else {
                    // By default, initial load size = 3 * NETWORK PAGE SIZE
                    // ensure we're not requesting duplicating items at the 2nd request
                    pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                }
            LoadResult.Page(
                data = dogImgList,
                prevKey = if (pageIndex == DB_STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val DB_STARTING_PAGE_INDEX = 1
    }
}