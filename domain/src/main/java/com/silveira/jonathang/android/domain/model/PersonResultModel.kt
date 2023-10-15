package com.silveira.jonathang.android.domain.model

data class PersonResultModel(
    override val id: Int,
    val name: String,
    val popularity: Double,
    val profilePath: String,
    val knownForDepartment: String,
    val knownFor: List<KnownForModel> = emptyList()
) : SearchResultModel