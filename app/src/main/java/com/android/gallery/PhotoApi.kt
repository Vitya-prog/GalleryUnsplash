package com.android.gallery

import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {
    @GET("/photos/?client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9")
    fun getPhotoList(): Call<List<Photo>>
}