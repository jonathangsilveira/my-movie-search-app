package com.silveira.jonathang.android.domain.mapper

import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.TV
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel
import com.silveira.jonathang.android.domain.model.TvShowResultModel
import com.silveira.jonathang.android.domain.model.TvShowsSectionModel

internal class TvShowSectionModelMappingStrategy : ItemsToSectionModelMappingStrategy {
    override val mediaType: MediaTypeEnum = TV

    override fun map(source: List<SearchResultModel>): SearchSectionModel {
        return TvShowsSectionModel(
            title = "TV Shows",
            items = source.filterIsInstance<TvShowResultModel>()
        )
    }
}