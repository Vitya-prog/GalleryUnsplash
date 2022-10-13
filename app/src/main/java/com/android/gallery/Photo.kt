package com.android.gallery
import com.google.gson.annotations.SerializedName
data class Photo(
    @SerializedName("id")
    var id:String,
    @SerializedName("description")
    var description:String?,
    @SerializedName("urls")
    var urls:Urls,
    @SerializedName("user")
    var user:User
)