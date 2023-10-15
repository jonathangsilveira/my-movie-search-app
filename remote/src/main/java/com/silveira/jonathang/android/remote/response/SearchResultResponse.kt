package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("media_type")
interface SearchResultResponse {
    val id: Int
}