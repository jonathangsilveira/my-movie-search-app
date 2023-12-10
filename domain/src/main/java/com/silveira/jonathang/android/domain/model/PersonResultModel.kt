package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.PERSON

data class PersonResultModel(
    override val id: Int,
    val name: String,
    val popularity: Double,
    val profilePath: String,
    val knownForDepartment: String,
    val knownFor: List<KnownForModel> = emptyList()
) : SearchResultModel {
    override val mediaType: MediaTypeEnum = PERSON
}