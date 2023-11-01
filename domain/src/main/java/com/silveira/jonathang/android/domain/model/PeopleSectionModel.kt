package com.silveira.jonathang.android.domain.model

import com.silveira.jonathang.android.domain.model.MediaTypeEnum.PERSON

data class PeopleSectionModel(
    override val title: String,
    val items: List<PersonResultModel>
) : SearchSectionModel {
    override val itemType: MediaTypeEnum = PERSON
}
