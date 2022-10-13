package com.android.gallery

import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("full")
    var full:String,
    @SerializedName("small")
    val small:String
)