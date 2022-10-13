package com.android.gallery.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.gallery.R
import com.android.gallery.databinding.FragmentPhotoBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
private const val TAG ="PhotoFragment"
@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private lateinit var binding:FragmentPhotoBinding
    private var url:String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoBinding.inflate(inflater,container,false)
        url =arguments?.getString("id")
        Glide.with(requireContext()).load(url).into(binding.imageView)
        return binding.root
    }

}