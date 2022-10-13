package com.android.gallery.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.android.gallery.data.Photo
import com.android.gallery.R
import com.android.gallery.databinding.FragmentPhotoListBinding
import dagger.hilt.android.AndroidEntryPoint
private const val TAG = "PhotoListFragment"
@AndroidEntryPoint
class PhotoListFragment : Fragment(),PhotoListAdapter.OnItemClickListener {

private lateinit var binding:FragmentPhotoListBinding
private val photoListViewModel: PhotoListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoListBinding.inflate(inflater,container,false)
        binding.recyclerView.layoutManager = GridLayoutManager(context,3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoListViewModel.photoList.observe(viewLifecycleOwner) {
            val adapter = PhotoListAdapter(this)
            adapter.submitList(it)
            binding.recyclerView.adapter = adapter
        }

    }

    override fun onClick(photo: Photo) {
        Log.d(TAG, photo.urls.full)
        val bundle = bundleOf( "id" to photo.urls.full)
        view?.findNavController()?.navigate(R.id.action_photoListFragment_to_photoFragment,bundle)
    }

}