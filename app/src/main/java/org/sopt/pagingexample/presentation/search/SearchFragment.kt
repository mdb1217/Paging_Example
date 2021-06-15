package org.sopt.pagingexample.presentation.search

import android.view.KeyEvent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.sopt.pagingexample.R
import org.sopt.pagingexample.databinding.FragmentSearchBinding
import org.sopt.pagingexample.presentation.base.BaseFragment
import org.sopt.pagingexample.presentation.search.adapter.DogListAdapter
import org.sopt.pagingexample.presentation.search.adapter.DogLoadStateAdapter
import org.sopt.pagingexample.presentation.viewmodel.MainViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_search
    override val viewModel: MainViewModel by viewModel()
    private val dogListAdapter = DogListAdapter()

    override fun initView() {
        initAdapter()
        initSearchEvent()
    }

    private fun initSearchEvent() {
        binding.apply {
            etSearch.setOnKeyListener { _, keyCode, event ->
                if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    getDog(etSearch.text.toString())
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false;
            }
        }
    }

    private fun initAdapter() {
        binding.rvSearch.adapter = dogListAdapter
        dogListAdapter.withLoadStateHeaderAndFooter(header = DogLoadStateAdapter(), footer = DogLoadStateAdapter())
    }

    private fun getDog(path : String) {
        lifecycleScope.launch {
            viewModel.getDog(path).collectLatest {
                dogListAdapter.submitData(it)
            }
        }
    }
}