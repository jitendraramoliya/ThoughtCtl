package com.example.example

import com.google.gson.annotations.SerializedName


data class ImageListRes(

    @SerializedName("data") var data: ArrayList<ImgurData> = arrayListOf(),
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("status") var status: Int? = null

)