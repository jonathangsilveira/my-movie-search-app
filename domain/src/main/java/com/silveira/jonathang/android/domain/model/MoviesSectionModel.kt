package com.silveira.jonathang.android.domain.model

data class MoviesSectionModel(
    override val title: String,
    val items: List<MovieResultModel>
) : SearchSectionModel
