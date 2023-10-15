package com.silveira.jonathang.android.domain.model

data class TvShowResultModel(
    override val id: Int,
    val name: String,
    val posterPath: String,
    val popularity: Double,
    val originalLanguage: String,
    val originCountry: List<String>?,
    val firstAirDate: String?
) : SearchResultModel