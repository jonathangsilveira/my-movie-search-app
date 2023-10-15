package com.silveira.jonathang.android.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("person")
data class PersonResultResponse(
    override val id: Int,
    val name: String,
    val popularity: Double,
    @SerialName("profile_path") val profilePath: String,
    @SerialName("known_for_department") val knownForDepartment: String,
    @SerialName("known_for")val knownFor: List<KnownForResponse>
) : SearchResultResponse
