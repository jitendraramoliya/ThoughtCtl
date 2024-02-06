package com.example.example

import com.google.gson.annotations.SerializedName


data class ImgurData(

    @SerializedName("id") var id: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("datetime") var datetime: Int? = null,
    @SerializedName("cover") var cover: String? = null,
    @SerializedName("cover_width") var coverWidth: Int? = null,
    @SerializedName("cover_height") var coverHeight: Int? = null,
    @SerializedName("account_url") var accountUrl: String? = null,
    @SerializedName("account_id") var accountId: Int? = null,
    @SerializedName("privacy") var privacy: String? = null,
    @SerializedName("layout") var layout: String? = null,
    @SerializedName("views") var views: Int? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("ups") var ups: Int? = null,
    @SerializedName("downs") var downs: Int? = null,
    @SerializedName("points") var points: Int? = null,
    @SerializedName("score") var score: Int? = null,
    @SerializedName("is_album") var isAlbum: Boolean? = null,
    @SerializedName("vote") var vote: String? = null,
    @SerializedName("favorite") var favorite: Boolean? = null,
    @SerializedName("nsfw") var nsfw: Boolean? = null,
    @SerializedName("section") var section: String? = null,
    @SerializedName("comment_count") var commentCount: Int? = null,
    @SerializedName("favorite_count") var favoriteCount: Int? = null,
    @SerializedName("topic") var topic: String? = null,
    @SerializedName("topic_id") var topicId: String? = null,
    @SerializedName("images_count") var imagesCount: Int? = 0,
    @SerializedName("in_gallery") var inGallery: Boolean? = null,
    @SerializedName("is_ad") var isAd: Boolean? = null,
    @SerializedName("tags") var tags: ArrayList<Tags> = arrayListOf(),
    @SerializedName("ad_type") var adType: Int? = null,
    @SerializedName("ad_url") var adUrl: String? = null,
    @SerializedName("in_most_viral") var inMostViral: Boolean? = null,
    @SerializedName("include_album_ads") var includeAlbumAds: Boolean? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),


    )