package com.example.codingtest.presentation.features.photos.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.codingtest.R
import com.example.codingtest.databinding.ItemPhotoBinding
import com.example.codingtest.domain.model.PhotoModel
import com.example.codingtest.utils.glide

class PhotosAdapter(
    private val onLikeClick: (PhotoModel) -> Unit,
    private val onItemClick: (PhotoModel) -> Unit
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {
    private var items: MutableList<PhotoModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PhotosAdapter.PhotoViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    fun setItems(newItems: List<PhotoModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun updateItem(item: PhotoModel){
        val index = items.indexOfFirst { it.id == item.id }
        notifyItemRangeChanged(index, items.size)
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding, ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                absoluteAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?.let { onItemClick(items[it]) }
            }
            binding.ivLike.setOnClickListener {
                absoluteAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }?.let {
                    items[it].isLiked = !items[it].isLiked
                    onLikeClick(items[it]) }
            }
        }

        fun bind(item: PhotoModel) {

            with(binding) {
                photoImageView.glide(item.url)

                val layoutParams = itemView.layoutParams as RecyclerView.LayoutParams
                if (absoluteAdapterPosition % 2 == 0) {
                    photoImageView.layoutParams =
                        (photoImageView.layoutParams as RelativeLayout.LayoutParams).apply {
                            addRule(RelativeLayout.ALIGN_PARENT_END)
                        }
                } else {
                    photoImageView.layoutParams =
                        (photoImageView.layoutParams as RelativeLayout.LayoutParams).apply {
                            addRule(RelativeLayout.ALIGN_PARENT_START)
                        }
                }

                if (item.isLiked) {
                    ivLike.setImageResource(R.drawable.ic_unlike)
                } else {
                    ivLike.setImageResource(R.drawable.ic_like)
                }
//                itemView.layoutParams = layoutParams
            }
        }

    }

}