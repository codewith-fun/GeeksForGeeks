package com.codeblogs.geeksforgeeks.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class Model(
    @SerializedName("feed")
    @Expose
    val feed: Feed?,
    @SerializedName("items")
    @Expose
    val items: List<Item>?,
    @SerializedName("status")
    @Expose
    val status: String?
) //:HomeRecyclerViewItem()