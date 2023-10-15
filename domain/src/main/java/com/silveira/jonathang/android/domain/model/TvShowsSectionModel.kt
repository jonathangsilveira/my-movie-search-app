package com.silveira.jonathang.android.domain.model

data class TvShowsSectionModel(
    override val title: String,
    val items: List<TvShowResultModel>
) : SearchSectionModel
