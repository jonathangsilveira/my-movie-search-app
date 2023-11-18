package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.TV

data class TvShowsSectionModel(
    override val title: String,
    val items: List<TvShowResultModel>
) : SearchSectionModel {
    override val mediaType: MediaTypeEnum = TV
}
