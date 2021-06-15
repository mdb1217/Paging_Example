package org.sopt.pagingexample.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.pagingexample.databinding.ItemDogListBinding

class DogListAdapter : PagingDataAdapter<String, DogListAdapter.DogListViewHolder>(DogDiffUtil) {

    object DogDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListViewHolder {
        val binding: ItemDogListBinding = ItemDogListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)

        return DogListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, position) }
    }

    class DogListViewHolder(private val binding: ItemDogListBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(imgDog: String, position: Int) {
            binding.apply {
                Glide.with(ivDog.context).load(imgDog).into(ivDog)
                tvNum.text = position.toString()
            }
        }
    }
}