package com.codeblogs.geeksforgeeks.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Enclosure(
    @SerializedName("link")
    @Expose
    val link: String?,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String?,
    @SerializedName("type")
    @Expose
    val type: String?
)