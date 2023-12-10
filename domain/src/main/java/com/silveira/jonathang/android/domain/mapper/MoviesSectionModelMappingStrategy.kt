package com.silveira.jonathang.android.domain.mapper

import com.silveira.jonathang.android.domain.model.MediaTypeEnum
import com.silveira.jonathang.android.domain.model.MediaTypeEnum.MOVIE
import com.silveira.jonathang.android.domain.model.MovieResultModel
import com.silveira.jonathang.android.domain.model.MoviesSectionModel
import com.silveira.jonathang.android.domain.model.SearchResultModel
import com.silveira.jonathang.android.domain.model.SearchSectionModel

internal class MoviesSectionModelMappingStrategy : ItemsToSectionModelMappingStrategy {
    override val mediaType: MediaTypeEnum = MOVIE

    override fun map(source: List<SearchResultModel>): SearchSectionModel {
        return MoviesSectionModel(
            title = "Movies",
            items = source.filterIsInstance<MovieResultModel>()
        )
    }
}