package com.silveira.jonathang.android.domain.mapper

import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.PERSON
import com.silveira.jonathang.android.domain.model.PeopleSectionModel
import com.silveira.jonathang.android.domain.model.PersonResultModel
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel

internal class PeopleSectionModelMappingStrategy : ItemsToSectionModelMappingStrategy {

    override val mediaType: MediaTypeEnum = PERSON

    override fun map(source: List<SearchResultModel>): SearchSectionModel {
        return PeopleSectionModel(
            title = "People",
            items = source.filterIsInstance<PersonResultModel>()
        )
    }
}