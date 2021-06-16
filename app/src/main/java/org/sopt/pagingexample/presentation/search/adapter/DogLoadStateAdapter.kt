package org.sopt.pagingexample.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.pagingexample.R
import org.sopt.pagingexample.databinding.ItemLoadStateBinding

// Adapter that displays a loading spinner when
// state = LoadState.Loading, and an error message and retry
// button when state is LoadState.Error.
class DogLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<DogLoadStateAdapter.LoadStateViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = LoadStateViewHolder(parent, retry)

    override fun onBindViewHolder(
        holder: LoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)

    class LoadStateViewHolder(
        parent: ViewGroup,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_load_state, parent, false)
    ) {
        private val binding = ItemLoadStateBinding.bind(itemView)

        fun bind(loadState: LoadState) {
            binding.pbCircle.isVisible = loadState is LoadState.Loading
        }
    }
}


