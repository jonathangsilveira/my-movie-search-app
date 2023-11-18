package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.MOVIE

data class MovieResultModel(
    override val id: Int,
    val title: String,
    val posterPath: String,
    val popularity: Double,
    val originalLanguage: String,
    val releaseDate : String
) : SearchResultModel {
    override val mediaType: MediaTypeEnum = MOVIE
}