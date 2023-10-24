package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("tv")
data class TvShowResultResponse(
    override val id: Int,
    val name: String? = null,
    val popularity: Double,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("original_language") val originalLanguage: String? = null,
    @SerialName("origin_country") val originCountry: List<String>? = null,
    @SerialName("first_air_date") val firstAirDate: String? = null
) : SearchResultResponse