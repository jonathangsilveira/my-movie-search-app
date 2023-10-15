package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MediaTypeResponse {
    @SerialName("tv") TV,
    @SerialName("person") PERSON,
    @SerialName("movie") MOVIE
}