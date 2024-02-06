package com.thoughtctlapp.api

import com.example.example.ImageListRes
import retrofit2.Response
import retrofit2.http.GET

interface ImgApiService {

    @GET("gallery/hot/viral/")
    suspend fun getImageList(): Response<ImageListRes>

}