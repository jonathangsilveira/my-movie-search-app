package com.silveira.jonathang.android.mymoviesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silveira.jonathang.android.domain.model.SearchHeaderModel
import com.silveira.jonathang.android.domain.model.SearchQueryModel
import com.silveira.jonathang.android.domain.model.SearchResultPageModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel
import com.silveira.jonathang.android.domain.usecase.GroupSearchResultBySectionUseCase
import com.silveira.jonathang.android.domain.usecase.MultiSearchUseCase
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
internal class SearchViewModel(
    private val multiSearchUseCase: MultiSearchUseCase,
    private val groupSearchResultBySectionUseCase: GroupSearchResultBySectionUseCase
) : ViewModel() {
    private val queryState = MutableStateFlow("")

    init {
        viewModelScope.launch {
            queryState.debounce(500L)
                .distinctUntilChanged()
                .filter { query -> query.trim().length >= 3 }
                .flowOn(Default)
                .collectLatest(::multiSearch)
        }
    }

    fun onQueryTextChanged(query: String) {
        queryState.value = query
    }

    private fun multiSearch(term: String) {
        viewModelScope.launch {
            val header = SearchHeaderModel(
                "application/json",
                ""
            )
            val query = SearchQueryModel(query = term, language = "pt-BR")
            multiSearchUseCase(header, query)
                .onSuccess(::onSuccess)
                .mapCatching(groupSearchResultBySectionUseCase::invoke)
                .onSuccess(::onGroupingSuccess)
                .onFailure(::onFailure)
        }
    }

    private fun onSuccess(resultPage: SearchResultPageModel) {
        val message = "${resultPage.totalResults} results in  ${resultPage.totalPages} pages!"
        println("MyMovieSearchApp -> onSuccess: $message")
    }

    private fun onGroupingSuccess(sections: List<SearchSectionModel>) {
        val groups = sections.joinToString { it.mediaType.name }
        println("MyMovieSearchApp -> onGroupingSuccess: $groups")
    }

    private fun onFailure(cause: Throwable) {
        println("MyMovieSearchApp -> onFailure: ${cause.message}")
        cause.printStackTrace()
    }
}