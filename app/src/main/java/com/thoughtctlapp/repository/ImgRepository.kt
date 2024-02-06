package com.thoughtctlapp.repository

import com.example.example.ImgurData
import com.thoughtctlapp.api.ImgApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

open class ImgRepository @Inject constructor(private val imgApiService: ImgApiService) {

    private var _imgMutableList = MutableStateFlow<List<ImgurData>>(emptyList())
    public val imgList: StateFlow<List<ImgurData>>
        get() = _imgMutableList

    suspend fun getImgList() {
        val response = imgApiService.getImageList()
        if (response.isSuccessful && response.body() != null && response.body()?.status == 200) {
            println(response.body().toString())
            _imgMutableList.emit(response.body()!!.data)
        }
    }

}