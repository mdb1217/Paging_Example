package org.sopt.pagingexample.presentation.search

import android.view.KeyEvent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.sopt.pagingexample.R
import org.sopt.pagingexample.databinding.FragmentSearchBinding
import org.sopt.pagingexample.presentation.base.BaseFragment
import org.sopt.pagingexample.presentation.search.adapter.DogListAdapter
import org.sopt.pagingexample.presentation.viewmodel.MainViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_search
    override val viewModel: MainViewModel by viewModels()
    private val dogListAdapter = DogListAdapter()

    override fun initView() {
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

    private fun getDog(path : String) {
        lifecycleScope.launch {
            viewModel.getDog(path).collectLatest {
                dogListAdapter.submitData(it)
            }
        }
    }
}