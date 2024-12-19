package com.wsa.pixabayassignment

import com.google.gson.annotations.SerializedName


data class PixabayResponse(
    @SerializedName("hits")  val hits: List<ImageData>
)

data class ImageData(
   @SerializedName("id")  val id: Int,
   @SerializedName("largeImageURL") val largeImageURL: String,
   @SerializedName("username") val username: String,
   @SerializedName("likes")  val likes: Int,
   @SerializedName("views")   val views: Int,
   @SerializedName("downloads")    val downloads: Int
)

