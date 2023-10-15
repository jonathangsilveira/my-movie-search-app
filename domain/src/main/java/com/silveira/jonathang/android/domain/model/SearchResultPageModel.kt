package com.silveira.jonathang.android.domain.model

data class SearchResultPageModel(
    val page: Int,
    val results: List<SearchResultModel>,
    val totalPages: Int,
    val totalResults: Int
)
