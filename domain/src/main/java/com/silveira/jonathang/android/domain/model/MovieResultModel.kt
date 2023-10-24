package com.silveira.jonathang.android.domain.model

data class MovieResultModel(
    override val id: Int,
    val title: String,
    val posterPath: String,
    val popularity: Double,
    val originalLanguage: String,
    val releaseDate : String
) : SearchResultModel