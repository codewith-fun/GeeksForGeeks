package com.codeblogs.geeksforgeeks.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class Feed(
    @SerializedName("author")
    @Expose
    val author: String?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("image")
    @Expose
    val image: String?,
    @SerializedName("link")
    @Expose
    val link: String?,
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("url")
    @Expose
    val url: String?
)