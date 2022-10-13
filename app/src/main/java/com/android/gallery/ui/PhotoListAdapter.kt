package com.android.gallery.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.gallery.data.Photo
import com.android.gallery.R
import com.bumptech.glide.Glide

class PhotoListAdapter(private val listener:OnItemClickListener):
ListAdapter<Photo, PhotoListAdapter.PhotoViewHolder>(DiffCallBack()){
    interface OnItemClickListener {
        fun onClick(photo: Photo)
    }

    class PhotoViewHolder(view: View):ViewHolder(view) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val smallImageView: ImageView = itemView.findViewById(R.id.fullImageView)
        fun bind(photo: Photo){
            nameTextView.text = if(photo.description != null) photo.description else "Нет названия"
            authorTextView.text = photo.user.username
            Glide.with(itemView).load(photo.urls.small).into(smallImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onClick(getItem(position))
        }
        holder.bind(getItem(position))
    }
}

class DiffCallBack:DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
       return oldItem == newItem
    }

}
