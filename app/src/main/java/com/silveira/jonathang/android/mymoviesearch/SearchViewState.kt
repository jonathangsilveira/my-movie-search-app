package com.silveira.jonathang.android.mymoviesearch

import com.silveira.jonathang.android.domain.model.SearchSectionModel

sealed interface SearchViewState {
    data object EmptyState : SearchViewState
    data object Fetching : SearchViewState
    data class Success(val sections: List<SearchSectionModel>) : SearchViewState
    data object GenericError : SearchViewState
    data object NoResults : SearchViewState
}
