package com.silveira.jonathang.android.mymoviesearch

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel
import com.silveira.jonathang.android.domain.usecase.GroupSearchResultBySectionUseCase
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCase
import com.silveira.jonathang.android.mymoviesearch.SearchViewState.EmptyState
import com.silveira.jonathang.android.mymoviesearch.SearchViewState.Fetching
import com.silveira.jonathang.android.mymoviesearch.SearchViewState.NoResults
import com.silveira.jonathang.android.mymoviesearch.SearchViewState.Success
import com.silveira.jonathang.android.mymoviesearch.usecase.HandleDebounceQueryUseCase
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val MIN_QUERY_LENGTH = 3

internal class SearchViewModel(
    private val multiSearchUseCase: MultiSearchUseCase,
    private val groupSearchResultBySectionUseCase: GroupSearchResultBySectionUseCase,
    private val handleDebounceQueryUseCase: HandleDebounceQueryUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow<SearchViewState>(EmptyState)
    val viewState: StateFlow<SearchViewState>
        get() = _viewState

    init {
        viewModelScope.launch {
            handleDebounceQueryUseCase.consume(MIN_QUERY_LENGTH)
                .flowOn(Default)
                .collectLatest(::multiSearch)
        }
    }

    fun onQueryTextChanged(query: String) {
        handleDebounceQueryUseCase(query)
    }

    fun onItemClicked(mediaType: MediaTypeEnum, id: Int) {
        Log.d("Search", "Item $id with media type $mediaType was clicked")
    }

    private fun multiSearch(term: String) {
        viewModelScope.launch {
            _viewState.update { Fetching }
            val query = SearchQueryModel(query = term, language = "pt-BR")
            multiSearchUseCase(query)
                .onSuccess(::onSuccess)
                .mapCatching(groupSearchResultBySectionUseCase::invoke)
                .onSuccess(::onGroupingSuccess)
                .onFailure(::onFailure)
        }
    }

    private fun onSuccess(resultPage: SearchResultPageModel) {
        if (resultPage.totalResults == 0) {
            _viewState.update { NoResults }
        }
    }

    private fun onGroupingSuccess(sections: List<SearchSectionModel>) {
        _viewState.update {
            if (sections.isEmpty()) {
                NoResults
            } else {
                Success(sections)
            }
        }
    }

    private fun onFailure(cause: Throwable) {
        Log.d("Search", "Error on fetching results!", cause)
        _viewState.update { SearchViewState.GenericError }
    }
}