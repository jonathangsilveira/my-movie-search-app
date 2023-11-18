package com.silveira.jonathang.android.domain.model

data class SearchQueryModel(
    val query: String,
    val language: String,
    val page: Int = 1,
    val includeAdult: Boolean = false
)