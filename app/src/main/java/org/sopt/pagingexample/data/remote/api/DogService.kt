package org.sopt.pagingexample.data.remote.api

import org.sopt.pagingexample.data.remote.model.ResDogImgList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogService {
    @GET("breed/{dog}/images")
    suspend fun getFollower(
        @Path("dog") dog : String,
        @Query("page") page: Int
    ): ResDogImgList
}