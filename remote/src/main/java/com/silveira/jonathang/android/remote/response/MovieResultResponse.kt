package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("movie")
data class MovieResultResponse(
    override val id: Int,
    val title: String,
    val popularity: Double,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("poster_path") val posterPath: String? = null
) : SearchResultResponse