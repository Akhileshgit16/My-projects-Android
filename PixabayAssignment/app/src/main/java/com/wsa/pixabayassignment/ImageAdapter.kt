package com.wsa.pixabayassignment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageAdapter(
    val imageList: List<ImageData>,
    val onItemClick: (ImageData) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_tv)
        val userTextView: TextView = itemView.findViewById(R.id.user_tv)
        val likesTextView: TextView = itemView.findViewById(R.id.like_tv)
        val viewsTextView: TextView = itemView.findViewById(R.id.views_tv)
        val downloadsTextView: TextView = itemView.findViewById(R.id.download_tv)

        fun bind(imageData: ImageData) {
            Picasso.get().load(imageData.largeImageURL).into(imageView)
            userTextView.text = imageData.username
            likesTextView.text = "Likes: ${imageData.likes}"
            viewsTextView.text = "Views: ${imageData.views}"
            downloadsTextView.text = "Downloads: ${imageData.downloads}"


            itemView.setOnClickListener {
                Log.d("ImageAdapter", "Item clicked: ${imageData.username}")  // Add logging
                onItemClick(imageData)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}

