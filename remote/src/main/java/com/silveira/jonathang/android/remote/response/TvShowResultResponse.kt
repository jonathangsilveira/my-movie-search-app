package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("tv")
data class TvShowResultResponse(
    override val id: Int,
    val name: String,
    val popularity: Double,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("origin_country") val originCountry: List<String>? = null,
    @SerialName("first_air_date") val firstAirDate: String? = null
) : SearchResultResponse
