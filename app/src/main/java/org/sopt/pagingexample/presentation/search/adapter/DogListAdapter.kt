package org.sopt.pagingexample.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.pagingexample.databinding.ItemDogListBinding

class DogListAdapter(diffCallback: DiffUtil.ItemCallback<String>) :
    PagingDataAdapter<String, DogListAdapter.DogListViewHolder>(diffCallback) {
    private val _data = mutableListOf<String>()
    var data : List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListViewHolder {
        val binding: ItemDogListBinding = ItemDogListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)

        return DogListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogListViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    override fun getItemCount(): Int = _data.size

    inner class DogListViewHolder(private val binding: ItemDogListBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(imgDog: String) {
            binding.apply {
                Glide.with(ivDog.context).load(imgDog).into(ivDog)
            }
        }
    }
}