package com.silveira.jonathang.android.domain.model

data class PeopleSectionModel(
    override val title: String,
    val items: List<PersonResultModel>
) : SearchSectionModel
