package org.sopt.pagingexample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import org.sopt.pagingexample.data.repository.DogRepository

class MainViewModel(private val repo: DogRepository) : ViewModel() {
    fun getDog(path : String) : Flow<PagingData<String>> = repo.getDog(path).cachedIn(viewModelScope)
}