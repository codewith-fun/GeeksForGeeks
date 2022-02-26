package com.codeblogs.geeksforgeeks.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("author")
    @Expose
    val author: String?,
    @SerializedName("categories")
    @Expose
    val categories: List<String>?,
    @SerializedName("content")
    @Expose
    val content: String?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("enclosure")
    @Expose
    val enclosure: Enclosure?,
    @SerializedName("guid")
    @Expose
    val guid: String?,
    @SerializedName("link")
    @Expose
    val link: String?,
    @SerializedName("pubDate")
    @Expose
    val pubDate: String?,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String?,
    @SerializedName("title")
    @Expose
    val title: String?
)