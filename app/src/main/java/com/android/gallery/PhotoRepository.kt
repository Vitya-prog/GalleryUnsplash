package com.android.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
private const val TAG ="PhotoRepository"
class PhotoRepository @Inject constructor(
    private val photoApi: PhotoApi
) {
    fun getPhotoList(): LiveData<List<Photo>> {
        val photoListLiveData = MutableLiveData<List<Photo>>()
        photoApi.getPhotoList().enqueue(object:Callback<List<Photo>>{
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photos = response.body()
                Log.d(TAG,"$photos")
                photoListLiveData.value = photos ?: mutableListOf()
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d(TAG,"$t")
            }
        })
        return photoListLiveData
    }
}