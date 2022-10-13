package com.android.gallery.ui

import androidx.lifecycle.ViewModel
import com.android.gallery.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    photoRepository: PhotoRepository
):ViewModel() {
    val photoList = photoRepository.getPhotoList()
}