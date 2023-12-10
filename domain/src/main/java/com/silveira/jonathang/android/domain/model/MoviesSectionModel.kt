package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.MOVIE

data class MoviesSectionModel(
    override val title: String,
    val items: List<MovieResultModel>
) : SearchSectionModel {
    override val mediaType: MediaTypeEnum = MOVIE
}
