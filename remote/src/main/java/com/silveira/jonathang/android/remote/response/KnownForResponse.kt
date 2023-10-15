package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class KnownForResponse(
    val id: Int,
    val title: String? = null
)