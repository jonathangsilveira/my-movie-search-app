package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.TV

data class TvShowResultModel(
    override val id: Int,
    val name: String,
    val posterPath: String,
    val popularity: Double,
    val originalLanguage: String,
    val originCountry: List<String>?,
    val firstAirDate: String?
) : SearchResultModel {
    override val mediaType: MediaTypeEnum = TV
}